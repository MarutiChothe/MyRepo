package com.hsbc.intg.customer.info.impl;


/**
 * @author Sreenu Dandu
 * @version 1.0 Class Description : Enum holding all possible error codes from
 *          SP for DATA ERROR Exception scenarios only.
 */
public enum CustomerDAOEnum {

	EXPLN_CODE_1003("AD2000","DATA ERROR"),
    EXPLN_CODE_1001("1001","DATA ERROR"),
    EXPLN_CODE_1002("1002","DATA ERROR"),
    EXPLN_CODE_1005("1005","DATA ERROR"),
    EXPLN_CODE_1006("1006","DATA ERROR"),
    EXPLN_CODE_8001("8001","APPLICATION ERROR"),
    EXPLN_CODE_8007("8007","APPLICATION ERROR");
    
	

    private String explnCode;
    private String explMsg;

    private CustomerDAOEnum(final String argExplnCode,final String argExplMsg) {
        this.explnCode = argExplnCode;
        this.explMsg = argExplMsg;
    }

    /**
     * This method searches for the presence of Enum entry of the passed string
     * argument
     * 
     * @param argExplnCode
     * @return boolean
     */
    public static boolean contains(final String argExplnCode) {
        if (null == argExplnCode) {
            return false;
        }

        for (final CustomerDAOEnum explnCodeType : CustomerDAOEnum
            .values()) {
            if (explnCodeType.explnCode.equals(argExplnCode)) {
                return true;
            }
        }
        return false;
    }
    
    /**
     * This method searches for the presence of Enum entry of the passed string
     * argument
     * 
     * @param argExplnCode
     * @return boolean
     */
    public static boolean checkType(final String argExplMsg) {
        if (null == argExplMsg) {
            return false;
        }

        for (final CustomerDAOEnum explnCodeType : CustomerDAOEnum
            .values()) {
            if (explnCodeType.explMsg.equals(argExplMsg)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return this.explnCode;
    }
}
