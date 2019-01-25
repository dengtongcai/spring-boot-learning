/**
 * 注意GlobalExceptionHandler和MvcErrorViewResolver作用范围不要重叠
 * 如果同时起作用，优先走RestControllerAdvice
 *
 * @author cc
 * @date 2019/1/25
 */
package me.datoucai.web.advices;