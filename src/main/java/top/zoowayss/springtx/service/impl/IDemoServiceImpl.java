package top.zoowayss.springtx.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import top.zoowayss.springtx.entity.DemoEntity;
import top.zoowayss.springtx.mapper.DemoEntityMapper;
import top.zoowayss.springtx.service.IDemoService;

/**
 * @Author: <a href="https://github.com/zoowayss">zoowayss</a>
 * @Date: 2024/4/17 19:01
 */
@Service
public class IDemoServiceImpl extends ServiceImpl<DemoEntityMapper, DemoEntity> implements IDemoService {


    @SneakyThrows
    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void changeOrderStatusTo2() {
        DemoEntity.class.getConstructor().newInstance();
        DemoEntity demoEntity = new DemoEntity();
        demoEntity.setId(1781245270718291969L);
        demoEntity.setStatus(2);
        this.baseMapper.updateById(demoEntity);
        int i = 10 / 0;
    }

    @Override
    public void changeOrderStatusTo3() {
        DemoEntity demoEntity = new DemoEntity();
        demoEntity.setId(1L);
        demoEntity.setStatus(3);
        this.baseMapper.updateById(demoEntity);
        int i = 10 / 0;
    }
}
