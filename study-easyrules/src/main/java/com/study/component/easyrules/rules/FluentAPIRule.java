package com.study.component.easyrules.rules;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import org.jeasy.rules.api.Facts;
import org.jeasy.rules.api.Rule;
import org.jeasy.rules.api.Rules;
import org.jeasy.rules.api.RulesEngine;
import org.jeasy.rules.core.DefaultRulesEngine;
import org.jeasy.rules.core.RuleBuilder;

/**
 * 链式编程创建规则
 */
public class FluentAPI {
    public static Rule createFluentRule() {
        return new RuleBuilder().name("weather rule").description("FluentAPI 下雨了就打伞").when(facts -> facts.get("rain").equals(true)).then(facts -> System.out.println("FluentAPI 下雨了，带伞")).build();
    }
}

class TestFluentAPI {
    public static void main(String[] args) {
        //创建事实
        Facts facts = new Facts();
        facts.put("rain", true);
        //注册规则
        Rules rules = new Rules();
        rules.register(FluentAPI.createFluentRule());
        //执行规则
        RulesEngine engine = new DefaultRulesEngine();
        engine.fire(rules, facts);
    }
}
