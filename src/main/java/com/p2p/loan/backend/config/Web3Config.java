package com.p2p.loan.backend.config;

import com.alibaba.fastjson2.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.web3j.crypto.Credentials;
import org.web3j.crypto.RawTransaction;
import org.web3j.crypto.TransactionEncoder;
import org.web3j.crypto.WalletUtils;
import org.web3j.crypto.exception.CipherException;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.admin.Admin;
import org.web3j.protocol.admin.methods.response.PersonalUnlockAccount;
import org.web3j.protocol.core.DefaultBlockParameterName;
import org.web3j.protocol.core.methods.response.EthGetTransactionCount;
import org.web3j.protocol.core.methods.response.EthSendTransaction;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.protocol.core.methods.response.Web3ClientVersion;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.Transfer;
import org.web3j.utils.Convert;
import org.web3j.utils.Numeric;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;

@Configuration
@Slf4j
public class Web3Config {

    @Bean
    public String web3() throws Exception {
        Web3j web3 = Web3j.build(new HttpService("http://172.31.0.3:8545/"));
        Credentials credentials = Credentials.create("0xac0974bec39a17e36ba4a6b4d238ff944bacb478cbed5efcae784d7bf4f2ff80");


//        TransactionReceipt transactionReceipt = Transfer.sendFunds(
//                        web3, credentials, "0x70997970C51812dc3A010C7d01b50e0d17dc79C8",
//                        BigDecimal.valueOf(10.9), Convert.Unit.ETHER)
//                .send();




        // get the next available nonce
        /*EthGetTransactionCount ethGetTransactionCount = web3.ethGetTransactionCount(
                "0xf39Fd6e51aad88F6F4ce6aB8827279cffFb92266", DefaultBlockParameterName.LATEST).send();
        BigInteger nonce = ethGetTransactionCount.getTransactionCount();
        log.info("nonce = "+nonce);

        // create our transaction
        BigInteger wei = Convert.toWei("10.9", Convert.Unit.ETHER).toBigInteger();
        RawTransaction rawTransaction  = RawTransaction.createEtherTransaction(
                nonce, BigInteger.valueOf(603746516), BigInteger.valueOf(30000), "0x70997970C51812dc3A010C7d01b50e0d17dc79C8", wei);

        // sign & send our transaction
        byte[] signedMessage = TransactionEncoder.signMessage(rawTransaction, credentials);
        String hexValue = Numeric.toHexString(signedMessage);
        EthSendTransaction ethSendTransaction = web3.ethSendRawTransaction(hexValue).send();
        log.info(JSON.toJSONString(ethSendTransaction));*/






//        YourSmartContract contract = YourSmartContract.deploy(
//                <web3j>, <credentials>,
//        <contractGasProvider>,
//        <param1>, ..., <paramN>).send();


        return "A";
    }

}
