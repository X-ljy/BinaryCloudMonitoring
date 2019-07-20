package com.binary.servermonitor.repository;

import com.binary.servermonitor.entity.WarnRule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

/**
 * @author Wei Peng
 */
@Repository
public interface WarnRuleRepository extends JpaRepository<WarnRule,Integer> {
    public WarnRule findByIdAndRuleName(Integer id,String rulename);
    public WarnRule findByUsername(String username);
    public WarnRule findByRuleName(String ruleName);
    public WarnRule findByRuleNameAndUsername(String ruleName,String username);
    public ArrayList<WarnRule> findAllByUsername(String username);
    public ArrayList<WarnRule> findAllByCycle(String cycle);

}
