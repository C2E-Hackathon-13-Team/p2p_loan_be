package com.p2p.loan.backend.config;

import com.alibaba.fastjson2.JSON;
import com.p2p.loan.backend.contracts.Loan;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.web3j.abi.FunctionEncoder;
import org.web3j.abi.FunctionReturnDecoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.*;
import org.web3j.crypto.exception.CipherException;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.admin.Admin;
import org.web3j.protocol.admin.methods.response.PersonalUnlockAccount;
import org.web3j.protocol.core.DefaultBlockParameterName;
import org.web3j.protocol.core.RemoteFunctionCall;
import org.web3j.protocol.core.methods.request.Transaction;
import org.web3j.protocol.core.methods.response.*;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.Contract;
import org.web3j.tx.Transfer;
import org.web3j.tx.gas.DefaultGasProvider;
import org.web3j.utils.Convert;
import org.web3j.utils.Numeric;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

@Configuration
@Slf4j
public class Web3Config {

    @Value("${web3j.url}")
    private String url;

    @Value("${web3j.loan-contract-address}")
    private String loanContractAddress;

    @Value("${web3j.owner-private-key}")
    private String ownerPrivateKey;

    @Bean
    public Loan web3()  {
        Web3j web3 = Web3j.build(new HttpService(url));
        Credentials credentials = Credentials.create(ownerPrivateKey);
        log.info("loanContractAddress="+loanContractAddress);
        return Loan.load( loanContractAddress, web3, credentials, new DefaultGasProvider());
    }

}
