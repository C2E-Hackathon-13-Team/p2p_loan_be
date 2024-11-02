package com.p2p.loan.backend.service;

import com.p2p.loan.backend.entity.Launcher;
import com.baomidou.mybatisplus.extension.service.IService;
import com.p2p.loan.backend.vo.RegisterLauncherReqVO;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author chenqilin
 * @since 2024-10-31
 */
public interface ILauncherService extends IService<Launcher> {

    Boolean registerLauncher(RegisterLauncherReqVO param) throws Exception;
}
