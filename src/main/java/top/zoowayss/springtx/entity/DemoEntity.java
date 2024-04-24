package top.zoowayss.springtx.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

import java.io.Serializable;

/**
 * @Author: <a href="https://github.com/zoowayss">zoowayss</a>
 * @Date: 2024/4/17 18:51
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@TableName("t_demo")
public class DemoEntity implements Serializable {

    private static final long serialVersionUID = 3380842994125115656L;

    private Long id;

    private Integer status;

    private String content;

    private String emails;
}
