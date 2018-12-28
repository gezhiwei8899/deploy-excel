package com.ddhz.hospitalcommunity.workmgr.vo;

import com.alibaba.fastjson.annotation.JSONField;
import com.ddhz.hospitalcommunity.common.enums.InviteTypeEnum;
import com.ddhz.hospitalcommunity.excel.Excel;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.Date;

/**
 * @ClassName: ExcelWorkerMgrVO
 * @Author: 葛志伟(赛事)
 * @Description:
 * @Date: 2018/12/25 15:02
 * @modified By:
 */
public class ExcelWorkerMgrVO {

    @Excel(name = "状态", sort = 0)
    private String status;

    @Excel(name = "社工ID", sort = 0)
    private Long userId;

    @Excel(name = "性别", sort = 0)
    private Integer sex;

    @Excel(name = "姓名", sort = 0)
    private String userRealName;

    @Excel(name = "手机号码", sort = 0)
    private String mobile;

    @Excel(name = "微信头像", sort = 0)
    private String faceUrl;

    @Excel(name = "昵称", sort = 0)
    private String nickName;

    @Excel(name = "加入时间", sort = 0)
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    @Excel(name = "离职时间", sort = 0)
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date leftTime;

    @Excel(name = "邀请者", sort = 0)
    private String inviter;

    @Excel(name = "邀请类型", sort = 0)
    private String inviteType;

    @Excel(name = "医院", sort = 0)
    private String hospitalName;

    @Excel(name = "志愿者数", sort = 0)
    private Integer volunteerNum;

    @Excel(name = "名片", sort = 0)
    private String personCard;


    public ExcelWorkerMgrVO(WorkerMgrVo workerManagerMgrVo) {
        this.status = parse(workerManagerMgrVo.getStatus());
        this.userId = workerManagerMgrVo.getUserId();
        this.sex = workerManagerMgrVo.getSex();
        this.userRealName = workerManagerMgrVo.getUserRealName();
        this.mobile = workerManagerMgrVo.getMobile();
        this.faceUrl = workerManagerMgrVo.getFaceUrl();
        this.nickName = workerManagerMgrVo.getNickName();
        this.createTime = workerManagerMgrVo.getCreateTime();
        this.leftTime = workerManagerMgrVo.getLeftTime();
        this.inviter = workerManagerMgrVo.getInviter();
        this.inviteType = parseInvite(workerManagerMgrVo.getInviteType());
        this.hospitalName = workerManagerMgrVo.getHospitalName();
        this.volunteerNum = workerManagerMgrVo.getVolunteerNum();
        this.personCard = workerManagerMgrVo.getPersonCard();
    }

    private String parseInvite(Integer inviteType) {
        if (InviteTypeEnum.ADMIN.getCode().equals(inviteType)) {
            return InviteTypeEnum.ADMIN.getDesc();
        }
        if (InviteTypeEnum.MANUAL.getCode().equals(inviteType)) {
            return InviteTypeEnum.MANUAL.getDesc();
        }
        if (InviteTypeEnum.LINK.getCode().equals(inviteType)) {
            return InviteTypeEnum.LINK.getDesc();
        }
        return "";
    }

    private String parse(Integer status) {
        if (status == 0) {
            return "离职";
        }
        return "在职";
    }


    public String getStatus() {
        return status;
    }

    public ExcelWorkerMgrVO setStatus(String status) {
        this.status = status;
        return this;
    }

    public Long getUserId() {
        return userId;
    }

    public ExcelWorkerMgrVO setUserId(Long userId) {
        this.userId = userId;
        return this;
    }

    public Integer getSex() {
        return sex;
    }

    public ExcelWorkerMgrVO setSex(Integer sex) {
        this.sex = sex;
        return this;
    }

    public String getUserRealName() {
        return userRealName;
    }

    public ExcelWorkerMgrVO setUserRealName(String userRealName) {
        this.userRealName = userRealName;
        return this;
    }

    public String getMobile() {
        return mobile;
    }

    public ExcelWorkerMgrVO setMobile(String mobile) {
        this.mobile = mobile;
        return this;
    }

    public String getFaceUrl() {
        return faceUrl;
    }

    public ExcelWorkerMgrVO setFaceUrl(String faceUrl) {
        this.faceUrl = faceUrl;
        return this;
    }

    public String getNickName() {
        return nickName;
    }

    public ExcelWorkerMgrVO setNickName(String nickName) {
        this.nickName = nickName;
        return this;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public ExcelWorkerMgrVO setCreateTime(Date createTime) {
        this.createTime = createTime;
        return this;
    }

    public Date getLeftTime() {
        return leftTime;
    }

    public ExcelWorkerMgrVO setLeftTime(Date leftTime) {
        this.leftTime = leftTime;
        return this;
    }

    public String getInviter() {
        return inviter;
    }

    public ExcelWorkerMgrVO setInviter(String inviter) {
        this.inviter = inviter;
        return this;
    }

    public String getInviteType() {
        return inviteType;
    }

    public ExcelWorkerMgrVO setInviteType(String inviteType) {
        this.inviteType = inviteType;
        return this;
    }

    public String getHospitalName() {
        return hospitalName;
    }

    public ExcelWorkerMgrVO setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
        return this;
    }

    public Integer getVolunteerNum() {
        return volunteerNum;
    }

    public ExcelWorkerMgrVO setVolunteerNum(Integer volunteerNum) {
        this.volunteerNum = volunteerNum;
        return this;
    }

    public String getPersonCard() {
        return personCard;
    }

    public ExcelWorkerMgrVO setPersonCard(String personCard) {
        this.personCard = personCard;
        return this;
    }
}
