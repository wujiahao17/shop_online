package com.example.shop_online.controller;

import com.example.shop_online.common.exception.ServerException;
import com.example.shop_online.common.result.Result;
import com.example.shop_online.entity.UserShippingAddress;
import com.example.shop_online.service.UserShippingAddressService;
import com.example.shop_online.vo.AddressVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.example.shop_online.common.utils.ObtainUserIdUtils.getUserId;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author wujiahao
 * @since 2023-11-09
 */
@Tag(name = "地址管理")
@RestController
@RequestMapping("member")
@AllArgsConstructor
public class UserShippingAddressController {
    private final UserShippingAddressService userShippingAddressService;

    @Operation(summary = "添加收货地址")
    @PostMapping("address")
    public Result<Integer> saveAddress(@RequestBody @Validated AddressVO addressVO, HttpServletRequest request) {
        Integer userId = getUserId(request);
        addressVO.setUserId(userId);
        Integer addressId = userShippingAddressService.saveShippingAddress(addressVO);
        return Result.ok(addressId);
    }

    @Operation(summary = "修改收货地址")
    @PutMapping("address")
    public Result<Integer> editAddress(@RequestBody @Validated AddressVO addressVO, HttpServletRequest request) {
        if (addressVO.getId() == null) {
            throw new ServerException("请求参数不能为空");
        }
        addressVO.setUserId(getUserId(request));
        Integer addressId = userShippingAddressService.editShippingAddress(addressVO);
        return Result.ok(addressId);
    }

//    @Operation(summary = "获取收货地址")
//    @PutMapping("address")
//    public Result<List<UserShippingAddress>> getAddress(@RequestBody @Validated AddressVO addressVO, HttpServletRequest request) {
//        if (addressVO.getId() == null) {
//            throw new ServerException("请求参数不能为空");
//        }
//        addressVO.setUserId(getUserId(request));
//        List<UserShippingAddress> address = userShippingAddressService.findAddress(getUserId(request));
//        return Result.ok(address);
//    }
}
