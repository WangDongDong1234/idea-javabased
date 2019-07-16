package lession.interview2;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * @program: javabased
 * @description: ${description}
 * @author: Mr.Wang
 * @create: 2019-07-09 23:15
 **/
@AllArgsConstructor
public enum CountryEnum {

    ONE(1,"齐"),TWO(2,"楚"),THREE(3,"燕"),FOUR(4,"赵"),FIVE(5,"魏"),SIX(6,"韩");
    @Getter
    private Integer retCode;
    @Getter
    private String retMessage;

    // CountryEnum(Integer retCode, String retMessage) {
    //     this.retCode = retCode;
    //     this.retMessage = retMessage;
    // }

    public static CountryEnum forEach_countryEnum(int index){
        CountryEnum[] myArray=CountryEnum.values();
        for(CountryEnum element:myArray){
            if(index==element.getRetCode()){
                return element;
            }
        }
        return null;
    }
}
