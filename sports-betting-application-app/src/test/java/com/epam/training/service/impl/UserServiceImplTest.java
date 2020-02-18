package com.epam.training.service.impl;


import com.epam.training.dao.AdminDao;
import com.epam.training.dao.PlayerDao;
import com.epam.training.dao.UserDao;
import com.epam.training.model.user.Admin;
import com.epam.training.model.usergroup.Role;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(SpringRunner.class)
public class UserServiceImplTest {

    @Mock
    private  AdminDao adminDao;

    @InjectMocks
    private UserServiceImpl userService;

    @Test
    public void findAllAdmin_returnAdmins() {
        List<Admin> expected = new ArrayList<>();
        final Admin admin_0= new Admin();
        admin_0.setId(0);
        final Admin admin_1 = new Admin();
        admin_1.setId(1);
        expected.add(admin_0);
        expected.add(admin_1);

        doReturn(expected).when(adminDao).findAllByRole(Role.ADMINS);

        final List<? extends Admin> actual = userService.findAllAdmin();

        assertThat(expected.size()).isEqualTo(actual.size());

        verify(adminDao, times(1)).findAllByRole(Role.ADMINS);
    }

}