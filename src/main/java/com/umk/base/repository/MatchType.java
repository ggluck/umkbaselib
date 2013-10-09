package com.umk.base.repository;

/**
 * -查询匹配类型，配合QueryFilter使用
 * @author desire
 * @since 2013-04-25 17:24
 * @see QueryFilter
 * EQ("="), NE("<>"), LIKE("like"), GT(">"), LT("<"), GE(">="), LE("<="), IN("in"), NOTIN("not in");
 */
public enum MatchType {
    EQ,NE,LIKE,LT,GT,IN,GE,LE,NOTIN
}
