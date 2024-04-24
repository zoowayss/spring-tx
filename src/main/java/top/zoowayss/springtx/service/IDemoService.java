package top.zoowayss.springtx.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.transaction.annotation.Transactional;
import top.zoowayss.springtx.entity.DemoEntity;

/**
 * @Description:
 * @Author: <a href="https://github.com/zoowayss">zoowayss</a>
 * @Date: 2024/4/17 19:01
 */

public interface IDemoService extends IService<DemoEntity> {
    void changeOrderStatusTo2();

    @Transactional
    void changeOrderStatusTo3();
}
