package edu.cqupt.hospital.vo.hosp;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author LWenH
 * @create 2023/4/2 - 15:19
 */
@Data
public class HospitalSetQueryVo {

    @ApiModelProperty(value = "医院名称")
    private String hosname;

    @ApiModelProperty(value = "医院编号")
    private String hoscode;
}
