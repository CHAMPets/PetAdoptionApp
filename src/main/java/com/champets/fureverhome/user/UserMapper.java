package com.champets.fureverhome.user;

public class UserMapper {
    public static UserDto mapToUserDto(User user) {
        UserDto userDto = UserDto.builder()
                .id(user.getId())
                .emailAddress(user.getEmailAddress())
                .password(user.getPassword())
                .phoneNumber(user.getPhoneNumber())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .roleId(user.getRoleId())
                .lastDateModified(user.getLastDateModified())
                .createdBy(user.getCreatedBy())
                .lastModifiedBy(user.getLastModifiedBy())
                .createdDate(user.getCreatedDate())
                .build();
        return userDto;
    }
}
