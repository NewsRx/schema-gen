package com.javagen.gen.model

import com.javagen.gen.Gen
import com.javagen.gen.java.SchemaToJava
import com.javagen.gen.schema.XmlSchemaNormalizer
import com.javagen.gen.schema.node.Attribute
import com.javagen.gen.schema.node.ComplexType
import com.javagen.gen.schema.node.Schema
import com.javagen.gen.schema.node.SimpleType
import spock.lang.Shared
import spock.lang.Specification

import static com.javagen.gen.schema.node.Schema.getDEFAULT_NS
import static com.javagen.gen.schema.node.Schema.getTargetNamespace

class MModuleSpec extends Specification
{
    @Shared def prefixToNamespaceMap = ['xsd':DEFAULT_NS, 'gpx':'http://www.topografix.com/GPX/1/1', targetNamespace:'http://www.topografix.com/GPX/1/1']

    def "fileName from class name and fileName attr"()
    {
        given:
        Gen gen = new SchemaToJava()
        MModule m1 = new MModule(name: 'm1')
        MClass c1 = new MClass(name:'C1')
        m1.addClass(c1)
        when:
        File f1 = gen.classOutputFile.apply(gen, c1)
        then:
        f1 != null
        f1.toString().endsWith('src/main/java-gen/m1/C1.java')
        when:
        gen.classOutputFile = { gen_,clazz -> Gen.fileNmeFromAttr(gen_, clazz, 'fileName', false) }
        f1 = gen.classOutputFile.apply(gen, c1)
        then:
        f1.toString().endsWith('NoFileNameAttrSet.java')
        when:
        m1.attr['fileName'] = 'S'
        f1 = gen.classOutputFile.apply(gen, c1)
        then:
        f1.toString().endsWith('S.java')
        when:
        c1.attr['fileName'] = 'X'
        f1 = gen.classOutputFile.apply(gen, c1)
        then:
        f1.toString().endsWith('X.java')
    }

}
