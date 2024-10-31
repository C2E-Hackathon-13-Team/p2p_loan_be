package com.p2p.loan.backend.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <p>
 * 
 * </p>
 *
 * @author chenqilin
 * @since 2024-10-31
 */
@Schema(description = "Launcher对象")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Launcher implements Serializable {

    private static final long serialVersionUID = 1L;

    @Schema(description = "地址")
    private String address;

    @Schema(description = "姓名")
    private String uname;

    @Schema(description = "创建时间")
    private Date createTime;

    @Schema(description = "更新时间")
    private Date updateTime;
}
