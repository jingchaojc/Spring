package com.example.demo;
import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.bitable.v1.model.*;
import java.util.HashMap;
import java.util.UUID;

import com.lark.oapi.core.request.RequestOptions;
public class CreateAppTableRecordSample {
    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("cli_a68a69cd1d395013", "7gsIJORp2stfaTuCFXdYVhpeBw15UU35").build();
        String uuid = UUID.randomUUID().toString();
        // 创建请求对象
        CreateAppTableRecordReq req = CreateAppTableRecordReq.newBuilder()
                .appToken("XtDhb6jugaGCbKs0XvmcVUT0nqh")
                .tableId("tblYpyVi4ruYHAiy")
                .userIdType("open_id")
                .clientToken(uuid)
                .appTableRecord(AppTableRecord.newBuilder()
                        .fields(new HashMap < String, Object > () {
                            {
                                put("文本", "张三丰1");
                            }
                        })
                        .build())
                .build();

        // 发起请求
        CreateAppTableRecordResp resp = client.bitable().appTableRecord().create(req, RequestOptions.newBuilder()
                .userAccessToken("u-cDA2KA6XlbmV1ftXuXi6volhgYjg0079VO001hgw0fBI")
                .build());

        // 处理服务端错误
        if(!resp.success()) {
            System.out.println(String.format("code:%s,msg:%s,reqId:%s", resp.getCode(), resp.getMsg(), resp.getRequestId()));
            return;
        }

        // 业务数据处理
        System.out.println(Jsons.DEFAULT.toJson(resp.getData()));
    }
}
