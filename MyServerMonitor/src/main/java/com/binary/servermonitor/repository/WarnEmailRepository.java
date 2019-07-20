package com.binary.servermonitor.repository;

import com.binary.servermonitor.entity.WarnEmail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;


/**
 * @author Wei Peng
 */
@Repository
public interface WarnEmailRepository extends JpaRepository<WarnEmail,Integer> {
    public WarnEmail findByUsername(String username);
    public WarnEmail findByRuleId(Integer id);
    @Transactional
    public void deleteByRuleId(Integer id);

}
