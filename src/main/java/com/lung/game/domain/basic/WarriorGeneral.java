package com.lung.game.domain.basic;

import com.lung.game.mixed.RedisKeyPrefix;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.redis.core.RedisHash;

import java.util.Map;

/**
 * @author noseparte
 * @link github.com/noseparte
 * @date 2020/11/11 - 0:23
 * @implSpec 武将
 */
@Data
@ToString
@NoArgsConstructor
@RedisHash(RedisKeyPrefix.Basic.Warrior_General_Key)
@Document(collation = "warrior_general")
public class WarriorGeneral {

    @Id
    @Field("_id")
    private Long uid;

    /**
     *
     */
    @Field("gid")
    private int gid;

    /**
     * 武将等级
     */
    @Field("level")
    private int level;

    /**
     * 体力
     */
    @Field("stamina ")
    private int stamina;

    /**
     * 星级
     */
    @Field("star")
    private int star;

    /**
     * 统御值
     */
    @Field("rulingValue")
    private int rulingValue;

    /**
     * 自带战法
     */
    @Field("originSkill")
    private int originSkill;

    /**
     * 传承战法
     */
    @Field("extendedSkill")
    private int extendedSkill;

    /**
     * A WarriorGeneral's attribute points 武将基础属性点
     * including <p>
     * - force, 武力
     * - intelligence, 智力
     * - command, 统率
     * - speed, 速度
     * - politics, 政治
     * - and charisma. 魅力
     * </p>
     */
    @Field("attributePoints")
    private Map<Integer, Integer> attributePoints;

    /**
     * 第二战法
     */
    @Field("secondSkill")
    private int secondSkill;

    /**
     * 是否觉醒
     */
    @Field("awakened")
    private boolean awakened;

    /**
     * 觉醒战法
     */
    @Field("awakeSkill")
    private int awakeSkill;

    /**
     * 装备栏 <p>
     * 兵器、
     * 护甲、
     * 坐骑、
     * 宝物
     * </p>
     */
    @Field("equipmentMap")
    private Map<Integer, Integer> equipmentMap;


}
