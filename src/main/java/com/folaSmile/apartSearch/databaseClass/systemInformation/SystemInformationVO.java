package com.folaSmile.apartSearch.databaseClass.systemInformation;

public class SystemInformationVO {

    final private String clientVer;
    final private String databaseVer;
    final private String databaseRange;
    final private String notice;


    public SystemInformationVO(String databaseVer, String databaseRange, String noticeKey, String notice) {
        this.clientVer = "ver 1.01t";
        this.databaseVer = databaseVer;
        this.databaseRange = databaseRange;

        // (noticeKey == 1) means Use inner notice message
        // otherwise get notice message from database
        if (noticeKey.equals("1")) {
            this.notice = String.format("""
                    본 버전(%s)은 임시 배포용입니다. 데이터베이스 서버가 한시적으로 운영됩니다.
                                        
                    조회 시 결과 출력까지 몇 초의 시간이 걸립니다.
                    """, this.clientVer);
        } else {
            this.notice = notice;
        }

    }

    public String getClientVer() {
        return clientVer;
    }

    public String getDatabaseVer() {
        return databaseVer;
    }

    public String getDatabaseRange() {
        return databaseRange;
    }

    public String getNotice() {
        return notice;
    }
}