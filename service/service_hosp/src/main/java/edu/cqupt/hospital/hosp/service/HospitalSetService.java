package edu.cqupt.hospital.hosp.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import edu.cqupt.hospital.model.hosp.HospitalSet;
import edu.cqupt.hospital.vo.hosp.HospitalSetQueryVo;

/**
 * @author LWenH
 * @create 2023/4/1 - 15:13
 */
public interface HospitalSetService extends IService<HospitalSet> {

    /**
     * 根据条件分页查询医院设置信息
     *
     * @param current            页码数
     * @param limit              每页数量
     * @param hospitalSetQueryVo
     * @return
     */
    Page findHospitalSetPage(Long current, Long limit, HospitalSetQueryVo hospitalSetQueryVo);

    /**
     * 修改医院设置状态
     *
     * @param id
     * @param status
     * @return
     */
    boolean updateHospitalSetStatus(Long id, Integer status);

    /**
     * 新增医院设置信息
     *
     * @param hospitalSet
     * @return
     */
    boolean addHospitalSet(HospitalSet hospitalSet);
}
