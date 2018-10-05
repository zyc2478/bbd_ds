package com.autobid.api;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ppdai.open.core.*;
import org.apache.log4j.Logger;

import java.util.List;

@SuppressWarnings("deprecation")
public class PPDApiService {

    private static Logger logger = Logger.getLogger(PPDApiService.class);

    public static JSONArray bidList(String token, String startTime, String endTime, int pageIndex, int pageSize) throws Exception {
        //String url = "https://openapi.ppdai.com/invest/BidService/BidList";
        String url = "https://openapi.ppdai.com/bid/openapi/bidList";
        Result result = OpenApiClient.send(url, token,
                new PropertyObject("StartTime",startTime, ValueTypeEnum.DateTime),
                new PropertyObject("EndTime",endTime, ValueTypeEnum.DateTime),
                new PropertyObject("PageIndex",pageIndex, ValueTypeEnum.Int32),
                new PropertyObject("PageSize",pageSize, ValueTypeEnum.Int32));
        if(pageIndex==0){
            result = OpenApiClient.send(url, token,
                    new PropertyObject("StartTime",startTime, ValueTypeEnum.DateTime),
                    new PropertyObject("EndTime",endTime, ValueTypeEnum.DateTime),
                    new PropertyObject("PageSize",pageSize, ValueTypeEnum.Int32));
        }
        JSONObject resultJSON = JSONObject.parseObject(result.getContext());
        logger.info(String.valueOf(resultJSON));
        JSONArray bidListArray = resultJSON.getJSONArray("BidList");
        return bidListArray;
    }

}
