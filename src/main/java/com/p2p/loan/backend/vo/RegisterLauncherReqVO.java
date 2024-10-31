package com.p2p.loan.backend.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "注册筹资人请求对象")
public class RegisterLauncherReqVO {


    @Schema(description = "地址")
    private String address;

    @Schema(description = "姓名")
    private String uname;



}
