package com.qinchy.multidbdemo.domain.master;

import lombok.*;
import lombok.extern.java.Log;

import java.util.Date;

@Data
@Setter
@Getter
@Log
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@EqualsAndHashCode
@ToString
public class SaasUserInfo {
    private String userId;

    @NonNull
    private String userName;

    @NonNull
    private String password;

    @NonNull
    private String branchId;

    @NonNull
    private String branchName;

    private String notes;

    private String validFlag;

    private Date lastUpdateTime;

    private String lastUpdateUser;
}