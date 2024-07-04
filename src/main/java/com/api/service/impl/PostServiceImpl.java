package com.api.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.api.exception.BusinessException;
import com.api.common.ErrorCode;
import com.api.mapper.PostMapper;
import com.api.model.entity.Post;
import com.api.model.enums.PostGenderEnum;
import com.api.model.enums.PostReviewStatusEnum;
import com.api.service.PostService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

/**
 * 帖子服务实现
 *

 */
@Service
@Slf4j
public class PostServiceImpl extends ServiceImpl<PostMapper, Post> implements PostService {
    /**
     * 帖子服务实现类
     *
     */


        @Override
        public void validPost(Post post, boolean add) {
            if (post == null) {
                throw new BusinessException(ErrorCode.PARAMS_ERROR);
            }
            Integer age = post.getAge();
            Integer gender = post.getGender();
            String content = post.getContent();
            String job = post.getJob();
            String place = post.getPlace();
            String education = post.getEducation();
            String loveExp = post.getLoveExp();
            Integer reviewStatus = post.getReviewStatus();
            // 创建时，所有参数必须非空
            if (add) {
                if (StringUtils.isAnyBlank(content, job, place, education, loveExp) || ObjectUtils.anyNull(age, gender)) {
                    throw new BusinessException(ErrorCode.PARAMS_ERROR);
                }
            }
            if (StringUtils.isNotBlank(content) && content.length() > 8192) {
                throw new BusinessException(ErrorCode.PARAMS_ERROR, "内容过长");
            }
            if (reviewStatus != null && !PostReviewStatusEnum.getValues().contains(reviewStatus)) {
                throw new BusinessException(ErrorCode.PARAMS_ERROR);
            }
            if (age != null && (age < 18 || age > 100)) {
                throw new BusinessException(ErrorCode.PARAMS_ERROR, "年龄不符合要求");
            }
            if (gender != null && !PostGenderEnum.getValues().contains(gender)) {
                throw new BusinessException(ErrorCode.PARAMS_ERROR, "性别不符合要求");
            }
        }

}




