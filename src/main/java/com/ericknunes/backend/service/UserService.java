package com.ericknunes.backend.service;

import com.ericknunes.backend.persistence.domain.backend.Plan;
import com.ericknunes.backend.persistence.domain.backend.User;
import com.ericknunes.backend.persistence.domain.backend.UserRole;
import com.ericknunes.backend.persistence.repositories.PlanRepository;
import com.ericknunes.backend.persistence.repositories.RoleRepository;
import com.ericknunes.backend.persistence.repositories.UserRepository;
import com.ericknunes.enums.PlansEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Service
@Transactional(readOnly = true)
public class UserService {

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PlanRepository planRepository;

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public User createUser(User user, PlansEnum plansEnum, Set<UserRole> userRoles)
    {
        Plan plan = new Plan(plansEnum);

        //Faz com que tenha certeza que existe no banco
        if(!planRepository.existsById(plansEnum.getId()))
            plan = planRepository.save(plan);

        user.setPlan(plan);

        for(UserRole ur: userRoles)
            roleRepository.save(ur.getRole());

        user.getUserRoles().addAll(userRoles);

        user = userRepository.save(user);

        return user;
    }


}
