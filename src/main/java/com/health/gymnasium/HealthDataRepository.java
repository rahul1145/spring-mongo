package com.health.gymnasium;

import com.health.gymnasium.model.HealthData;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/*
* MongoRepository has all bootstrap code for all pre-requisite methods for crud operations on database*/
@Repository
public interface HealthDataRepository extends MongoRepository<HealthData,String> {
    <S extends HealthData> S insert(S entity);
}
