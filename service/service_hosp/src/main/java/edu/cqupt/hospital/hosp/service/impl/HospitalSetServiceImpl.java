package edu.cqupt.hospital.hosp.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import edu.cqupt.hospital.common.utils.MD5Utils;
import edu.cqupt.hospital.hosp.mapper.HospitalSetMapper;
import edu.cqupt.hospital.hosp.service.HospitalSetService;
import edu.cqupt.hospital.model.hosp.HospitalSet;
import edu.cqupt.hospital.vo.hosp.HospitalSetQueryVo;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Random;

/**
 * @author LWenH
 * @create 2023/4/1 - 15:25
 */
@Service
public class HospitalSetServiceImpl extends ServiceImpl<HospitalSetMapper, HospitalSet> implements HospitalSetService {

    /**
     * 根据条件分页查询医院设置信息
     *
     * @param current            页码数
     * @param limit              每页数量
     * @param hospitalSetQueryVo
     * @return
     */
    @Override
    public Page findHospitalSetPage(Long current, Long limit, HospitalSetQueryVo hospitalSetQueryVo) {
        Page<HospitalSet> page = new Page<>(current, limit);
        QueryWrapper<HospitalSet> wrapper = new QueryWrapper<>();
        String hosname = hospitalSetQueryVo.getHosname();
        String hoscode = hospitalSetQueryVo.getHoscode();
        if (! StringUtils.isEmpty(hosname)) {
            wrapper.like("hosname", hosname);
        }
        if (! StringUtils.isEmpty(hoscode)) {
            wrapper.eq("hoscode", hoscode);
        }
        return page(page, wrapper);
    }

    /**
     * 修改医院设置状态
     *
     * @param id
     * @param status
     * @return
     */
    @Override
    public boolean updateHospitalSetStatus(Long id, Integer status) {
        UpdateWrapper<HospitalSet> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("id", id);
        updateWrapper.set("status", status);
        return update(updateWrapper);
    }

    /**
     * 新增医院设置信息
     *
     * @param hospitalSet
     * @return
     */
    @Override
    public boolean addHospitalSet(HospitalSet hospitalSet) {
        hospitalSet.setStatus(1);
        // 生成签名秘钥
        Random random = new Random();
        String signKey = MD5Utils.encrypt(String.valueOf(System.currentTimeMillis()) + random.nextInt(1000));
        hospitalSet.setSignKey(signKey);
        return save(hospitalSet);
    }
}
