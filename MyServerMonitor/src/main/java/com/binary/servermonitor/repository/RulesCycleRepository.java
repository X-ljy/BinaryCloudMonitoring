package com.binary.servermonitor.repository;

import com.binary.servermonitor.entity.RuleCycle;
import com.binary.servermonitor.entity.WarnEmail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;


/**
 * @author Wei Peng
 */
@Repository
public interface RulesCycleRepository extends JpaRepository<RuleCycle,Integer> {
    public RuleCycle findByRulesId(Integer ruleId);
    @Transactional
    public void deleteByRulesId(Integer id);
}
