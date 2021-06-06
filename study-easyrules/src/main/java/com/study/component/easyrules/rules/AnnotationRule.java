package com.study.component.easyrules.rules;

import org.jeasy.rules.annotation.Action;
import org.jeasy.rules.annotation.Condition;


import org.jeasy.rules.annotation.Fact;
import org.jeasy.rules.annotation.Rule;
import org.jeasy.rules.api.Facts;
import org.jeasy.rules.api.Rules;
import org.jeasy.rules.api.RulesEngine;
import org.jeasy.rules.core.DefaultRulesEngine;

/**
 * 注解形式创建规则
 */
@Rule(name = "weather rule", description = "AnnotationRule 如果下雨就打伞")
public class AnnotationRule {

    @Condition
    public boolean itRains(@Fact("rain") boolean rain) {
        return rain;
    }

    @Action
    public void takeUmbrella() {
        System.out.println("AnnotationRule 下雨了，带伞");
    }

}

class TestAnnotationRule {
    public static void main(String[] args) {
        //创建事实
        Facts facts = new Facts();
        facts.put("rain", true);
        //注册规则
        Rules rules = new Rules();
        rules.register(new AnnotationRule());
        //执行规则
        RulesEngine engine = new DefaultRulesEngine();
        engine.fire(rules, facts);
    }
}
