package cn.zdh.o2o.enums;

public enum ProductCategoryStateEnum {

    CHECK(0, "审核中"), OFFLINE(-1, "非法商品"), SUCCESS(1, "操作成功"),PASS(2, "通过认证"), INNER_ERROR(-1001, "内部系统错误")
    ,NULL_PRODUCTID(-1002, "ShopId为空"), NULL_PRODUCT(-1003, "商品信息为空");
    private int state;
    private String stateInfo;

    private ProductCategoryStateEnum(int state, String stateInfo){
        this.state = state;
        this.stateInfo = stateInfo;
    }

    public int getState() {
        return state;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    /**
     * 根据传入的state返回相应的enum值
     */

    public static ProductCategoryStateEnum stateOf(int state){
        for (ProductCategoryStateEnum stateEnum : values()) {
            if (stateEnum.getState() == state){
                return stateEnum;
            }
        }
        return null;
    }



}
