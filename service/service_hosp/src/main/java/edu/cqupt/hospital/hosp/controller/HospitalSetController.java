package edu.cqupt.hospital.hosp.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import edu.cqupt.hospital.common.result.Result;
import edu.cqupt.hospital.hosp.service.HospitalSetService;
import edu.cqupt.hospital.model.hosp.HospitalSet;
import edu.cqupt.hospital.vo.hosp.HospitalSetQueryVo;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author LWenH
 * @create 2023/4/1 - 15:18
 */
@RestController
@RequestMapping("/admin/hosp/hospitalSet")
public class HospitalSetController {

    @Autowired
    private HospitalSetService hospitalSetService;

    /**
     * 查询所有医院设置信息
     *
     * @return
     */
    @ApiOperation("查询所有医院设置信息")
    @GetMapping("hospSets/all")
    public Result findAll() {
        List<HospitalSet> list = hospitalSetService.list();
        return Result.ok(list);
    }

    /**
     * 根据id删除医院设置信息
     *
     * @param id
     * @return
     */
    @ApiOperation("根据id删除医院设置信息")
    @DeleteMapping("hospSets/{id}")
    public Result removeHospitalSetById(@PathVariable Long id) {
        boolean flag = hospitalSetService.removeById(id);
        if (flag) {
            return Result.ok();
        } else {
            return Result.fail();
        }
    }

    /**
     * 根据名称和编号条件查询 + 分页
     *
     * @return
     */
    @ApiOperation("根据名称和编号条件查询 + 分页")
    @PostMapping("hospSets/{current}/{limit}")
    public Result findHospitalSetPage(@PathVariable Long current,
                                      @PathVariable Long limit,
                                      @RequestBody(required = false) HospitalSetQueryVo hospitalSetQueryVo) {
        Page hospSetPage = hospitalSetService.findHospitalSetPage(current, limit, hospitalSetQueryVo);
        return Result.ok(hospSetPage);
    }


    /**
     * 新增医院设置信息
     *
     * @param hospitalSet
     * @return
     */
    @ApiOperation("新增医院设置信息")
    @PostMapping("hospSets")
    public Result addHospitalSet(@RequestBody HospitalSet hospitalSet) {
        boolean flag = hospitalSetService.addHospitalSet(hospitalSet);
        if (flag) {
            return Result.ok();
        } else {
            return Result.fail();
        }
    }

    /**
     * 根据id查找医院设置信息
     *
     * @param id
     * @return
     */
    @ApiOperation("根据id查找医院设置信息")
    @GetMapping("hospSets/{id}")
    public Result findHospitalSetById(@PathVariable Long id) {
        int i =  1 / 0;
        HospitalSet hospitalSet = hospitalSetService.getById(id);
        return Result.ok(hospitalSet);
    }

    /**
     * 修改医院设置信息
     *
     * @param hospitalSet
     * @return
     */
    @ApiOperation("修改医院设置信息")
    @PutMapping("hospSets")
    public Result updateHospitalSetById(@RequestBody HospitalSet hospitalSet) {
        boolean flag = hospitalSetService.updateById(hospitalSet);
        if (flag) {
            return Result.ok();
        } else {
            return Result.fail();
        }
    }

    /**
     * 批量删除医院设置信息
     *
     * @param idList
     * @return
     */
    @ApiOperation("批量删除医院设置信息")
    @DeleteMapping("hospSets")
    public Result batchRemoveHospitalSet(@RequestBody List<Long> idList) {
        boolean flag = hospitalSetService.removeByIds(idList);
        if (flag) {
            return Result.ok();
        } else {
            return Result.fail();
        }
    }

    /**
     * 修改医院设置状态（锁定/解锁）
     *
     * @param id
     * @param status
     * @return
     */
    @ApiOperation("修改医院设置状态（锁定/解锁）")
    @PutMapping("hosp/{id}/{status}")
    public Result setHospitalSetStatus(@PathVariable Long id, @PathVariable Integer status) {
        boolean flag = hospitalSetService.updateHospitalSetStatus(id, status);
        if (flag) {
            return Result.ok();
        } else {
            return Result.fail();
        }
    }

    /**
     * 发送医院签名秘钥
     *
     * @param id
     * @return
     */
    @ApiOperation("发送医院签名秘钥")
    @GetMapping("hosp/key/{id}")
    public Result sendKey(@PathVariable Long id) {
        HospitalSet hospitalSet = hospitalSetService.getById(id);
        String signKey = hospitalSet.getSignKey();
        // Todo 发送短信

        return Result.ok(signKey);
    }
}
