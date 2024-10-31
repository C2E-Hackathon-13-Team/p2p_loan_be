package com.p2p.loan.backend.controller;


import com.p2p.loan.backend.entity.RespBodyVO;
import com.p2p.loan.backend.service.ILauncherService;
import com.p2p.loan.backend.vo.RegisterLauncherReqVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("launcher")
@Tag(name = "筹资人")
@Slf4j
public class LauncherController {

    @Autowired
    private ILauncherService launcherService;


    @Operation(summary = "注册筹资人")
    @PostMapping("/registerLauncher")
    @ResponseBody
    public RespBodyVO<Boolean> registerLauncher(@RequestBody RegisterLauncherReqVO param){
        return RespBodyVO.success(launcherService.registerLauncher(param));
    }


}
