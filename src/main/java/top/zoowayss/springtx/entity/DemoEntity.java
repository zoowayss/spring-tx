package top.zoowayss.springtx.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: <a href="https://github.com/zoowayss">zoowayss</a>
 * @Date: 2024/4/17 18:51
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@TableName("t_demo")
public class DemoEntity {

    private Long id;

    private Integer status;

    private String content;
}
