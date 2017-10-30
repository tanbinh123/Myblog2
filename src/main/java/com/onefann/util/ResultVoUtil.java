package com.onefann.util;

import com.onefann.enums.ResultEnum;
import com.onefann.vo.ResultVo;

/**
 * Created by one_fann on 2017/10/25.
 */
public class ResultVoUtil {

    public static ResultVo success(Object o) {
        ResultVo resultVo = new ResultVo();
        resultVo.setCode(ResultEnum.SUCCESS.getCode());
        resultVo.setData(o);
        return resultVo;
    }

    public static ResultVo success(Integer code, String msg) {
        ResultVo resultVo = new ResultVo();
        resultVo.setCode(code);
        resultVo.setMsg(msg);
        return resultVo;
    }

    public static ResultVo success() {
        return success(null);
    }

    public static ResultVo error() {
        ResultVo resultVo = new ResultVo();
        resultVo.setCode(ResultEnum.ERROR.getCode());
        resultVo.setMsg(ResultEnum.ERROR.getMsg());
        return resultVo;
    }
    public static ResultVo error(String msg) {
        ResultVo resultVo = new ResultVo();
        resultVo.setCode(ResultEnum.ERROR.getCode());
        resultVo.setMsg(msg);
        return resultVo;
    }
    public static ResultVo error(Integer code,String msg) {
        ResultVo resultVo = new ResultVo();
        resultVo.setCode(code);
        resultVo.setMsg(msg);
        return resultVo;
    }
}
