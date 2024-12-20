package com.p2p.loan.backend.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.p2p.loan.backend.contracts.Loan;
import com.p2p.loan.backend.entity.Launcher;
import com.p2p.loan.backend.mapper.LauncherMapper;
import com.p2p.loan.backend.service.ILauncherService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.p2p.loan.backend.vo.RegisterLauncherReqVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.web3j.protocol.core.RemoteFunctionCall;
import org.web3j.protocol.core.methods.response.TransactionReceipt;

import java.util.Date;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author chenqilin
 * @since 2024-10-31
 */
@Service
public class LauncherServiceImpl extends ServiceImpl<LauncherMapper, Launcher> implements ILauncherService {

    @Autowired
    private Loan loan;

    @Override
    public Boolean registerLauncher(RegisterLauncherReqVO param) throws Exception {
        TransactionReceipt tr = loan.registerLauncher(param.getAddress()).send();
        if(tr!=null && tr.isStatusOK()){
            Launcher launcher = BeanUtil.copyProperties(param, Launcher.class);
            launcher.setCreateTime(new Date());
            launcher.setUpdateTime(new Date());
            return save(launcher);
        }else{
            return false;
        }
    }
}
