package com.binary.servermonitor.repository;

import com.binary.servermonitor.entity.WarnEmail;
import com.binary.servermonitor.entity.WarnRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.ArrayList;


/**
 * @author Wei Peng
 */
@Repository
public interface WarnRecordRepository extends JpaRepository<WarnRecord,Integer> {
    public WarnRecord findByUsername(String username);
    public ArrayList<WarnRecord> findAllByUsername(String username);
    public WarnRecord findByRuleId(Integer id);
    public WarnRecord findByUsernameAndWarnTime(String username,String warnTime);
    ArrayList<WarnRecord> findByUsernameAndWarnTimeAfter(String username,String time);
//    @Transactional
//    public void deleteByRuleId(Integer id);

}
