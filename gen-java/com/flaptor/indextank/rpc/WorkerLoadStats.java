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
public class WorkerLoadStats implements TBase<WorkerLoadStats, WorkerLoadStats._Fields>, java.io.Serializable, Cloneable {
    private static final TStruct STRUCT_DESC = new TStruct("WorkerLoadStats");

    private static final TField ONE_MINUTE_LOAD_FIELD_DESC = new TField("one_minute_load", TType.DOUBLE, (short) 1);
    private static final TField FIVE_MINUTES_LOAD_FIELD_DESC = new TField("five_minutes_load", TType.DOUBLE, (short) 2);
    private static final TField FIFTEEN_MINUTES_LOAD_FIELD_DESC = new TField("fifteen_minutes_load", TType.DOUBLE, (short) 3);

    private double one_minute_load;
    private double five_minutes_load;
    private double fifteen_minutes_load;

    /**
     * The set of fields this struct contains, along with convenience methods for finding and manipulating them.
     */
    public enum _Fields implements TFieldIdEnum {
        ONE_MINUTE_LOAD((short) 1, "one_minute_load"),
        FIVE_MINUTES_LOAD((short) 2, "five_minutes_load"),
        FIFTEEN_MINUTES_LOAD((short) 3, "fifteen_minutes_load");

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
                case 1: // ONE_MINUTE_LOAD
                    return ONE_MINUTE_LOAD;
                case 2: // FIVE_MINUTES_LOAD
                    return FIVE_MINUTES_LOAD;
                case 3: // FIFTEEN_MINUTES_LOAD
                    return FIFTEEN_MINUTES_LOAD;
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
    private static final int __ONE_MINUTE_LOAD_ISSET_ID = 0;
    private static final int __FIVE_MINUTES_LOAD_ISSET_ID = 1;
    private static final int __FIFTEEN_MINUTES_LOAD_ISSET_ID = 2;
    private BitSet __isset_bit_vector = new BitSet(3);

    public static final Map<_Fields, FieldMetaData> metaDataMap;

    static {
        Map<_Fields, FieldMetaData> tmpMap = new EnumMap<_Fields, FieldMetaData>(_Fields.class);
        tmpMap.put(_Fields.ONE_MINUTE_LOAD, new FieldMetaData("one_minute_load", TFieldRequirementType.DEFAULT,
                new FieldValueMetaData(TType.DOUBLE)));
        tmpMap.put(_Fields.FIVE_MINUTES_LOAD, new FieldMetaData("five_minutes_load", TFieldRequirementType.DEFAULT,
                new FieldValueMetaData(TType.DOUBLE)));
        tmpMap.put(_Fields.FIFTEEN_MINUTES_LOAD, new FieldMetaData("fifteen_minutes_load", TFieldRequirementType.DEFAULT,
                new FieldValueMetaData(TType.DOUBLE)));
        metaDataMap = Collections.unmodifiableMap(tmpMap);
        FieldMetaData.addStructMetaDataMap(WorkerLoadStats.class, metaDataMap);
    }

    public WorkerLoadStats() {
    }

    public WorkerLoadStats(
            double one_minute_load,
            double five_minutes_load,
            double fifteen_minutes_load) {
        this();
        this.one_minute_load = one_minute_load;
        set_one_minute_load_isSet(true);
        this.five_minutes_load = five_minutes_load;
        set_five_minutes_load_isSet(true);
        this.fifteen_minutes_load = fifteen_minutes_load;
        set_fifteen_minutes_load_isSet(true);
    }

    /**
     * Performs a deep copy on <i>other</i>.
     */
    public WorkerLoadStats(WorkerLoadStats other) {
        __isset_bit_vector.clear();
        __isset_bit_vector.or(other.__isset_bit_vector);
        this.one_minute_load = other.one_minute_load;
        this.five_minutes_load = other.five_minutes_load;
        this.fifteen_minutes_load = other.fifteen_minutes_load;
    }

    public WorkerLoadStats deepCopy() {
        return new WorkerLoadStats(this);
    }

    @Override
    public void clear() {
        set_one_minute_load_isSet(false);
        this.one_minute_load = 0.0;
        set_five_minutes_load_isSet(false);
        this.five_minutes_load = 0.0;
        set_fifteen_minutes_load_isSet(false);
        this.fifteen_minutes_load = 0.0;
    }

    public double get_one_minute_load() {
        return this.one_minute_load;
    }

    public WorkerLoadStats set_one_minute_load(double one_minute_load) {
        this.one_minute_load = one_minute_load;
        set_one_minute_load_isSet(true);
        return this;
    }

    public void unset_one_minute_load() {
        __isset_bit_vector.clear(__ONE_MINUTE_LOAD_ISSET_ID);
    }

    /**
     * Returns true if field one_minute_load is set (has been asigned a value) and false otherwise
     */
    public boolean is_set_one_minute_load() {
        return __isset_bit_vector.get(__ONE_MINUTE_LOAD_ISSET_ID);
    }

    public void set_one_minute_load_isSet(boolean value) {
        __isset_bit_vector.set(__ONE_MINUTE_LOAD_ISSET_ID, value);
    }

    public double get_five_minutes_load() {
        return this.five_minutes_load;
    }

    public WorkerLoadStats set_five_minutes_load(double five_minutes_load) {
        this.five_minutes_load = five_minutes_load;
        set_five_minutes_load_isSet(true);
        return this;
    }

    public void unset_five_minutes_load() {
        __isset_bit_vector.clear(__FIVE_MINUTES_LOAD_ISSET_ID);
    }

    /**
     * Returns true if field five_minutes_load is set (has been asigned a value) and false otherwise
     */
    public boolean is_set_five_minutes_load() {
        return __isset_bit_vector.get(__FIVE_MINUTES_LOAD_ISSET_ID);
    }

    public void set_five_minutes_load_isSet(boolean value) {
        __isset_bit_vector.set(__FIVE_MINUTES_LOAD_ISSET_ID, value);
    }

    public double get_fifteen_minutes_load() {
        return this.fifteen_minutes_load;
    }

    public WorkerLoadStats set_fifteen_minutes_load(double fifteen_minutes_load) {
        this.fifteen_minutes_load = fifteen_minutes_load;
        set_fifteen_minutes_load_isSet(true);
        return this;
    }

    public void unset_fifteen_minutes_load() {
        __isset_bit_vector.clear(__FIFTEEN_MINUTES_LOAD_ISSET_ID);
    }

    /**
     * Returns true if field fifteen_minutes_load is set (has been asigned a value) and false otherwise
     */
    public boolean is_set_fifteen_minutes_load() {
        return __isset_bit_vector.get(__FIFTEEN_MINUTES_LOAD_ISSET_ID);
    }

    public void set_fifteen_minutes_load_isSet(boolean value) {
        __isset_bit_vector.set(__FIFTEEN_MINUTES_LOAD_ISSET_ID, value);
    }

    public void setFieldValue(_Fields field, Object value) {
        switch (field) {
            case ONE_MINUTE_LOAD:
                if (value == null) {
                    unset_one_minute_load();
                } else {
                    set_one_minute_load((Double) value);
                }
                break;

            case FIVE_MINUTES_LOAD:
                if (value == null) {
                    unset_five_minutes_load();
                } else {
                    set_five_minutes_load((Double) value);
                }
                break;

            case FIFTEEN_MINUTES_LOAD:
                if (value == null) {
                    unset_fifteen_minutes_load();
                } else {
                    set_fifteen_minutes_load((Double) value);
                }
                break;

        }
    }

    public Object getFieldValue(_Fields field) {
        switch (field) {
            case ONE_MINUTE_LOAD:
                return new Double(get_one_minute_load());

            case FIVE_MINUTES_LOAD:
                return new Double(get_five_minutes_load());

            case FIFTEEN_MINUTES_LOAD:
                return new Double(get_fifteen_minutes_load());

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
            case ONE_MINUTE_LOAD:
                return is_set_one_minute_load();
            case FIVE_MINUTES_LOAD:
                return is_set_five_minutes_load();
            case FIFTEEN_MINUTES_LOAD:
                return is_set_fifteen_minutes_load();
        }
        throw new IllegalStateException();
    }

    @Override
    public boolean equals(Object that) {
        if (that == null)
            return false;
        if (that instanceof WorkerLoadStats)
            return this.equals((WorkerLoadStats) that);
        return false;
    }

    public boolean equals(WorkerLoadStats that) {
        if (that == null)
            return false;

        boolean this_present_one_minute_load = true;
        boolean that_present_one_minute_load = true;
        if (this_present_one_minute_load || that_present_one_minute_load) {
            if (!(this_present_one_minute_load && that_present_one_minute_load))
                return false;
            if (this.one_minute_load != that.one_minute_load)
                return false;
        }

        boolean this_present_five_minutes_load = true;
        boolean that_present_five_minutes_load = true;
        if (this_present_five_minutes_load || that_present_five_minutes_load) {
            if (!(this_present_five_minutes_load && that_present_five_minutes_load))
                return false;
            if (this.five_minutes_load != that.five_minutes_load)
                return false;
        }

        boolean this_present_fifteen_minutes_load = true;
        boolean that_present_fifteen_minutes_load = true;
        if (this_present_fifteen_minutes_load || that_present_fifteen_minutes_load) {
            if (!(this_present_fifteen_minutes_load && that_present_fifteen_minutes_load))
                return false;
            if (this.fifteen_minutes_load != that.fifteen_minutes_load)
                return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        return 0;
    }

    public int compareTo(WorkerLoadStats other) {
        if (!getClass().equals(other.getClass())) {
            return getClass().getName().compareTo(other.getClass().getName());
        }

        int lastComparison = 0;
        WorkerLoadStats typedOther = (WorkerLoadStats) other;

        lastComparison = Boolean.valueOf(is_set_one_minute_load()).compareTo(typedOther.is_set_one_minute_load());
        if (lastComparison != 0) {
            return lastComparison;
        }
        if (is_set_one_minute_load()) {
            lastComparison = TBaseHelper.compareTo(this.one_minute_load, typedOther.one_minute_load);
            if (lastComparison != 0) {
                return lastComparison;
            }
        }
        lastComparison = Boolean.valueOf(is_set_five_minutes_load()).compareTo(typedOther.is_set_five_minutes_load());
        if (lastComparison != 0) {
            return lastComparison;
        }
        if (is_set_five_minutes_load()) {
            lastComparison = TBaseHelper.compareTo(this.five_minutes_load, typedOther.five_minutes_load);
            if (lastComparison != 0) {
                return lastComparison;
            }
        }
        lastComparison = Boolean.valueOf(is_set_fifteen_minutes_load()).compareTo(typedOther.is_set_fifteen_minutes_load());
        if (lastComparison != 0) {
            return lastComparison;
        }
        if (is_set_fifteen_minutes_load()) {
            lastComparison = TBaseHelper.compareTo(this.fifteen_minutes_load, typedOther.fifteen_minutes_load);
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
                case 1: // ONE_MINUTE_LOAD
                    if (field.type == TType.DOUBLE) {
                        this.one_minute_load = iprot.readDouble();
                        set_one_minute_load_isSet(true);
                    } else {
                        TProtocolUtil.skip(iprot, field.type);
                    }
                    break;
                case 2: // FIVE_MINUTES_LOAD
                    if (field.type == TType.DOUBLE) {
                        this.five_minutes_load = iprot.readDouble();
                        set_five_minutes_load_isSet(true);
                    } else {
                        TProtocolUtil.skip(iprot, field.type);
                    }
                    break;
                case 3: // FIFTEEN_MINUTES_LOAD
                    if (field.type == TType.DOUBLE) {
                        this.fifteen_minutes_load = iprot.readDouble();
                        set_fifteen_minutes_load_isSet(true);
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
        oprot.writeFieldBegin(ONE_MINUTE_LOAD_FIELD_DESC);
        oprot.writeDouble(this.one_minute_load);
        oprot.writeFieldEnd();
        oprot.writeFieldBegin(FIVE_MINUTES_LOAD_FIELD_DESC);
        oprot.writeDouble(this.five_minutes_load);
        oprot.writeFieldEnd();
        oprot.writeFieldBegin(FIFTEEN_MINUTES_LOAD_FIELD_DESC);
        oprot.writeDouble(this.fifteen_minutes_load);
        oprot.writeFieldEnd();
        oprot.writeFieldStop();
        oprot.writeStructEnd();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("WorkerLoadStats(");
        boolean first = true;

        sb.append("one_minute_load:");
        sb.append(this.one_minute_load);
        first = false;
        if (!first) sb.append(", ");
        sb.append("five_minutes_load:");
        sb.append(this.five_minutes_load);
        first = false;
        if (!first) sb.append(", ");
        sb.append("fifteen_minutes_load:");
        sb.append(this.fifteen_minutes_load);
        first = false;
        sb.append(")");
        return sb.toString();
    }

    public void validate() throws TException {
        // check for required fields
    }

}

