package com.javagen.gen.swift

import com.javagen.gen.model.MCardinality
import com.javagen.gen.model.MType
import com.javagen.gen.model.MTypeRegistry

/**
 * Create a Swift-specific instance of the type registry.
 *
 * usage: MTypeRegistry.instance().lookupType('String')
 */
class SwiftTypeRegistry extends MTypeRegistry
{
    SwiftTypeRegistry(Map<String, MType> types)
    {
        super(types)
    }
    SwiftTypeRegistry()
    {
        this(defaultTypes())
    }

    static MType VOID = new MType(name:'Void')
    MType getVOID() { VOID }

    private static Map<String, MType> defaultTypes()
    {
        def t = []
        t << VOID
        t << new MType(name:'Any', val: 'nil')
        t << new MType(name:'String', val: '')
        t << new MType(name:'Int', val: '0')
        t << new MType(name:'Int8', val: '0')
        t << new MType(name:'Int16', val: '0')
        t << new MType(name:'Int32', val: '0')
        t << new MType(name:'Int64', val: '0')
        t << new MType(name:'UInt', val: '0')
        t << new MType(name:'UInt8', val: '0')
        t << new MType(name:'UInt16', val: '0')
        t << new MType(name:'UInt32', val: '0')
        t << new MType(name:'UInt64', val: '0')
        t << new MType(name:'Float', val: '0.0')
        t << new MType(name:'Double', val: '0.0')
        t << new MType(name:'Bool', val: 'false')
        t << new MType(name:'Character', val: '?')
        t << new MType(name:'UUID', val: 'UUID()')
//        t << new MType(name:'Integer', val: '0')
//        t << new MType(name:'Long', val: '0')
//        t << new MType(name:'Float', val: '0.0')
//        t << new MType(name:'Double', val: '0.0')
//        t << new MType(name:'Boolean', val: 'nil')
        t << new MType(name:'Date', val: 'Date()')
        t << new MType(name:'Optional')
        t << new MType(name:'Array', val: '[]')
        t << new MType(name:'Set', val: '[]')
        t << new MType(name:'Dictionary', val: '[:]')
        t << new MType(name:'Locale', val: 'Locale.current')
        //t << new MType(name:'java.time.ZonedDateTime')
        t << new MType(name:'URL')
        Map<String, MType> result = [:]
        for(MType type in t) {
            result[type.name] = type
        }
        result
//		t << new MType(name:'java.util.ArrayList')
//		t << new MType(name:'java.util.Locale')
//		t << new MType(name:'char',primitive:true)
//		t << new MType(name:'byte',primitive:true)
//		t << new MType(name:'int',primitive:true)
//		t << new MType(name:'long',primitive:true)
//		t << new MType(name:'float',primitive:true)
//		t << new MType(name:'double',primitive:true)
//		t << new MType(name:'boolean',primitive:true)
//		t << new MType(name:'void',primitive:true)
    }

     static String containerClassName(MCardinality container)
    {
        switch (container) {
            case MCardinality.MAP: return 'Dictionary'
            case MCardinality.SET: return 'Set'
            case MCardinality.LIST: return 'Array'
            case MCardinality.ARRAY: return 'Array'
            case MCardinality.OPTIONAL: return 'Optional'
            default: return null
        }
    }

    public static Map<String,String> simpleXmlTypeToPropertyType = [
            'anyType':'Any',
            'anySimpleType':'Any',
            //https://www.w3.org/TR/xmlschema-2/#built-in-primitive-datatypes
            'string':'String',
            'decimal':'Double',
            'boolean':'Bool',
            'duration':'String', //TODO
            'dateTime':'Date',
            'time':'Date',
            'date':'Date',
            'gYearMonth':'String', //TODO
            'gYear':'Int',
            'gMonthDay':'String', //TODO
            'gDay':'UInt8', //1st,2nd,3rd,etc. day of the month
            'gMonth':'UInt8',
            'hexBinary':'Data',
            'base64Binary':'Data',
            'anyURI':'String',
            'QName':'String', //TODO
            'NOTATION':'String',
            //https://www.w3.org/TR/xmlschema-2/#built-in-derived
            'integer':'Int',
            'nonPositiveInteger':'Int32',
            'nonNegativeInteger':'Int32',
            'long':'Int64',
            'int':'Int32',
            'short':'UInt16',
            'byte':'UInt8',
            'negativeInteger':'Int32',
            'positiveInteger':'Int32',
            'unsignedLong':'Int64',
            'unsignedInt':'Int32',
            'unsignedShort':'UInt16',
            'unsignedByte':'UInt8',
            'normalizedString':'String',
            'token':'String',
            'language':'String',
            'Name':'String',
            'NMTOKEN':'String',
            'NMTOKENS':'String',
            'NCName':'String',
            'ID':'String',
            'IDREF':'String',
            'IDREFS':'String',
            'ENTITY':'String',
            'ENTITIES':'String'
    ]

}
