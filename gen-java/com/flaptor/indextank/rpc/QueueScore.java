/**
 * Autogenerated by Thrift
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 */
package com.flaptor.indextank.rpc;

import org.apache.thrift.TBase;
import org.apache.thrift.TBaseHelper;
import org.apache.thrift.TException;
import org.apache.thrift.TFieldIdEnum;
import org.apache.thrift.TFieldRequirementType;
import org.apache.thrift.meta_data.FieldMetaData;
import org.apache.thrift.meta_data.FieldValueMetaData;
import org.apache.thrift.protocol.TField;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.protocol.TProtocolUtil;
import org.apache.thrift.protocol.TStruct;
import org.apache.thrift.protocol.TType;

import java.util.BitSet;
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("all")
public class QueueScore implements TBase<QueueScore, QueueScore._Fields>, java.io.Serializable, Cloneable {
    private static final TStruct STRUCT_DESC = new TStruct("QueueScore");

    private static final TField PRIORITY_FIELD_DESC = new TField("priority", TType.I32, (short) 1);
    private static final TField SCORE_FIELD_DESC = new TField("score", TType.DOUBLE, (short) 2);

    private int priority;
    private double score;

    /**
     * The set of fields this struct contains, along with convenience methods for finding and manipulating them.
     */
    public enum _Fields implements TFieldIdEnum {
        PRIORITY((short) 1, "priority"),
        SCORE((short) 2, "score");

        private static final Map<String, _Fields> byName = new HashMap<String, _Fields>();

        static {
            for (_Fields field : EnumSet.allOf(_Fields.class)) {
                byName.put(field.getFieldName(), field);
            }
        }

        /**
         * Find the _Fields constant that matches fieldId, or null if its not found.
         */
        public static _Fields findByThriftId(int fieldId) {
            switch (fieldId) {
                case 1: // PRIORITY
                    return PRIORITY;
                case 2: // SCORE
                    return SCORE;
                default:
                    return null;
            }
        }

        /**
         * Find the _Fields constant that matches fieldId, throwing an exception
         * if it is not found.
         */
        public static _Fields findByThriftIdOrThrow(int fieldId) {
            _Fields fields = findByThriftId(fieldId);
            if (fields == null) throw new IllegalArgumentException("Field " + fieldId + " doesn't exist!");
            return fields;
        }

        /**
         * Find the _Fields constant that matches name, or null if its not found.
         */
        public static _Fields findByName(String name) {
            return byName.get(name);
        }

        private final short _thriftId;
        private final String _fieldName;

        _Fields(short thriftId, String fieldName) {
            _thriftId = thriftId;
            _fieldName = fieldName;
        }

        public short getThriftFieldId() {
            return _thriftId;
        }

        public String getFieldName() {
            return _fieldName;
        }
    }

    // isset id assignments
    private static final int __PRIORITY_ISSET_ID = 0;
    private static final int __SCORE_ISSET_ID = 1;
    private BitSet __isset_bit_vector = new BitSet(2);

    public static final Map<_Fields, FieldMetaData> metaDataMap;

    static {
        Map<_Fields, FieldMetaData> tmpMap = new EnumMap<_Fields, FieldMetaData>(_Fields.class);
        tmpMap.put(_Fields.PRIORITY, new FieldMetaData("priority", TFieldRequirementType.DEFAULT,
                new FieldValueMetaData(TType.I32)));
        tmpMap.put(_Fields.SCORE, new FieldMetaData("score", TFieldRequirementType.DEFAULT,
                new FieldValueMetaData(TType.DOUBLE)));
        metaDataMap = Collections.unmodifiableMap(tmpMap);
        FieldMetaData.addStructMetaDataMap(QueueScore.class, metaDataMap);
    }

    public QueueScore() {
    }

    public QueueScore(
            int priority,
            double score) {
        this();
        this.priority = priority;
        set_priority_isSet(true);
        this.score = score;
        set_score_isSet(true);
    }

    /**
     * Performs a deep copy on <i>other</i>.
     */
    public QueueScore(QueueScore other) {
        __isset_bit_vector.clear();
        __isset_bit_vector.or(other.__isset_bit_vector);
        this.priority = other.priority;
        this.score = other.score;
    }

    public QueueScore deepCopy() {
        return new QueueScore(this);
    }

    @Override
    public void clear() {
        set_priority_isSet(false);
        this.priority = 0;
        set_score_isSet(false);
        this.score = 0.0;
    }

    public int get_priority() {
        return this.priority;
    }

    public QueueScore set_priority(int priority) {
        this.priority = priority;
        set_priority_isSet(true);
        return this;
    }

    public void unset_priority() {
        __isset_bit_vector.clear(__PRIORITY_ISSET_ID);
    }

    /**
     * Returns true if field priority is set (has been asigned a value) and false otherwise
     */
    public boolean is_set_priority() {
        return __isset_bit_vector.get(__PRIORITY_ISSET_ID);
    }

    public void set_priority_isSet(boolean value) {
        __isset_bit_vector.set(__PRIORITY_ISSET_ID, value);
    }

    public double get_score() {
        return this.score;
    }

    public QueueScore set_score(double score) {
        this.score = score;
        set_score_isSet(true);
        return this;
    }

    public void unset_score() {
        __isset_bit_vector.clear(__SCORE_ISSET_ID);
    }

    /**
     * Returns true if field score is set (has been asigned a value) and false otherwise
     */
    public boolean is_set_score() {
        return __isset_bit_vector.get(__SCORE_ISSET_ID);
    }

    public void set_score_isSet(boolean value) {
        __isset_bit_vector.set(__SCORE_ISSET_ID, value);
    }

    public void setFieldValue(_Fields field, Object value) {
        switch (field) {
            case PRIORITY:
                if (value == null) {
                    unset_priority();
                } else {
                    set_priority((Integer) value);
                }
                break;

            case SCORE:
                if (value == null) {
                    unset_score();
                } else {
                    set_score((Double) value);
                }
                break;

        }
    }

    public Object getFieldValue(_Fields field) {
        switch (field) {
            case PRIORITY:
                return new Integer(get_priority());

            case SCORE:
                return new Double(get_score());

        }
        throw new IllegalStateException();
    }

    /**
     * Returns true if field corresponding to fieldID is set (has been asigned a value) and false otherwise
     */
    public boolean isSet(_Fields field) {
        if (field == null) {
            throw new IllegalArgumentException();
        }

        switch (field) {
            case PRIORITY:
                return is_set_priority();
            case SCORE:
                return is_set_score();
        }
        throw new IllegalStateException();
    }

    @Override
    public boolean equals(Object that) {
        if (that == null)
            return false;
        if (that instanceof QueueScore)
            return this.equals((QueueScore) that);
        return false;
    }

    public boolean equals(QueueScore that) {
        if (that == null)
            return false;

        boolean this_present_priority = true;
        boolean that_present_priority = true;
        if (this_present_priority || that_present_priority) {
            if (!(this_present_priority && that_present_priority))
                return false;
            if (this.priority != that.priority)
                return false;
        }

        boolean this_present_score = true;
        boolean that_present_score = true;
        if (this_present_score || that_present_score) {
            if (!(this_present_score && that_present_score))
                return false;
            if (this.score != that.score)
                return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        return 0;
    }

    public int compareTo(QueueScore other) {
        if (!getClass().equals(other.getClass())) {
            return getClass().getName().compareTo(other.getClass().getName());
        }

        int lastComparison = 0;
        QueueScore typedOther = (QueueScore) other;

        lastComparison = Boolean.valueOf(is_set_priority()).compareTo(typedOther.is_set_priority());
        if (lastComparison != 0) {
            return lastComparison;
        }
        if (is_set_priority()) {
            lastComparison = TBaseHelper.compareTo(this.priority, typedOther.priority);
            if (lastComparison != 0) {
                return lastComparison;
            }
        }
        lastComparison = Boolean.valueOf(is_set_score()).compareTo(typedOther.is_set_score());
        if (lastComparison != 0) {
            return lastComparison;
        }
        if (is_set_score()) {
            lastComparison = TBaseHelper.compareTo(this.score, typedOther.score);
            if (lastComparison != 0) {
                return lastComparison;
            }
        }
        return 0;
    }

    public _Fields fieldForId(int fieldId) {
        return _Fields.findByThriftId(fieldId);
    }

    public void read(TProtocol iprot) throws TException {
        TField field;
        iprot.readStructBegin();
        while (true) {
            field = iprot.readFieldBegin();
            if (field.type == TType.STOP) {
                break;
            }
            switch (field.id) {
                case 1: // PRIORITY
                    if (field.type == TType.I32) {
                        this.priority = iprot.readI32();
                        set_priority_isSet(true);
                    } else {
                        TProtocolUtil.skip(iprot, field.type);
                    }
                    break;
                case 2: // SCORE
                    if (field.type == TType.DOUBLE) {
                        this.score = iprot.readDouble();
                        set_score_isSet(true);
                    } else {
                        TProtocolUtil.skip(iprot, field.type);
                    }
                    break;
                default:
                    TProtocolUtil.skip(iprot, field.type);
            }
            iprot.readFieldEnd();
        }
        iprot.readStructEnd();

        // check for required fields of primitive type, which can't be checked in the validate method
        validate();
    }

    public void write(TProtocol oprot) throws TException {
        validate();

        oprot.writeStructBegin(STRUCT_DESC);
        oprot.writeFieldBegin(PRIORITY_FIELD_DESC);
        oprot.writeI32(this.priority);
        oprot.writeFieldEnd();
        oprot.writeFieldBegin(SCORE_FIELD_DESC);
        oprot.writeDouble(this.score);
        oprot.writeFieldEnd();
        oprot.writeFieldStop();
        oprot.writeStructEnd();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("QueueScore(");
        boolean first = true;

        sb.append("priority:");
        sb.append(this.priority);
        first = false;
        if (!first) sb.append(", ");
        sb.append("score:");
        sb.append(this.score);
        first = false;
        sb.append(")");
        return sb.toString();
    }

    public void validate() throws TException {
        // check for required fields
    }

}

