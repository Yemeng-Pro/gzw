package 杂事;

import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;

import java.util.Map;

/**
 * @author shkstart
 * @create 2021-04-20 23:13
 */
public abstract class NetMall {
    protected Logger logger = LoggerFactory.getLogger(NetMall.class);
    String uId; // 􁊠􀲁ID
    String uPwd; // 􁊠􀲁􀩂􁎱
    public NetMall(String uId, String uPwd) {
        this.uId = uId;
        this.uPwd = uPwd;
    }

    public String generateGoodsPoster(String skuUrl) {
        if (!login(uId, uPwd)) return null; // 1. 􁸵􁦤􁌭􀭯
        Map<String, String> reptile = reptile(skuUrl); // 2. 􁆻􁡩􀠟􀟝
        return createBase64(reptile); // 3. 􁕟􁤰􁁹􀲸
    }
    // 􀽜􀳙􁌭􀭯
    protected abstract Boolean login(String uId, String uPwd);

    protected abstract Map<String, String> reptile(String skuUrl);

    protected abstract String createBase64(Map<String, String> goodsInfo);
}