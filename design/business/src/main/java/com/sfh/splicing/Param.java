package com.sfh.splicing;

/**
 * @user sfh
 * @date 2021/12/24 17:16
 */
public class Param {

    int fieldName;

    String field;

    public static final int XXX=1;
    public static final int YYY=2;


    public BuildSql BuildSql(){
        return new BuildSql(this);
    }

    private class BuildSql {
        StringBuilder builder=new StringBuilder(512);
        Param param;
        public BuildSql(Param param) {
        this.param=param;

        builder.append("select * from xxx where ");
        }

        public void fieldName(){
            switch (param.fieldName){
                case XXX:
                    builder.append("xxx=? ");
                    break;
                case YYY:
                    this.conditionAndTypeAndOwasp();
                    break;
                default:
            }
        }

        public String build(){
            return builder.toString();
        }

        private void conditionAndTypeAndOwasp() {
            //xxxxxxxxx
        }

    }
}
