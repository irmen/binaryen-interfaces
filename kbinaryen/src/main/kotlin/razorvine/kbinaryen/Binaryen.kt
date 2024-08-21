package razorvine.kbinaryen

// ---------------------- KOTLIN SOURCE -----------------
import com.sun.jna.*

// typealiases:
class BinaryenModule: Structure()
class BinaryenExpression: Structure()
class BinaryenFunction: Structure()
class BinaryenMemory: Structure()
class BinaryenExport: Structure()
class BinaryenGlobal: Structure()
class BinaryenTag: Structure()
class BinaryenTable: Structure()
class BinaryenElementSegment: Structure()
class Relooper: Structure()
class RelooperBlock: Structure()
class CExpressionRunner: Structure()
class TypeBuilder: Structure()
typealias BinaryenIndex = Int
typealias BinaryenType = Long
typealias BinaryenPackedType = Int
typealias BinaryenHeapType = Pointer
typealias BinaryenExpressionId = Int
typealias BinaryenExternalKind = Int
typealias BinaryenFeatures = Int
typealias BinaryenModuleRef = Pointer
class BinaryenLiteral: Structure()
typealias BinaryenOp = Int
typealias BinaryenExpressionRef = Pointer
typealias BinaryenFunctionRef = Pointer
typealias BinaryenMemoryRef = Pointer
typealias BinaryenExportRef = Pointer
typealias BinaryenGlobalRef = Pointer
typealias BinaryenTagRef = Pointer
typealias BinaryenTableRef = Pointer
typealias BinaryenElementSegmentRef = Pointer
class BinaryenBufferSizes: Structure()
class BinaryenModuleAllocateAndWriteResult: Structure()
typealias BinaryenSideEffects = Int
typealias RelooperRef = Pointer
typealias RelooperBlockRef = Pointer
typealias ExpressionRunnerRef = Pointer
typealias ExpressionRunnerFlags = Int
typealias TypeBuilderRef = Pointer
typealias TypeBuilderErrorReason = Int
typealias BinaryenBasicHeapType = Int


interface Binaryen: Library {

    companion object {
        init {
            if(!Platform.isWindows())
                System.setProperty("jna.library.path", "/usr/local/lib")
        }

        val INSTANCE: Binaryen by lazy { Native.load("binaryen", Binaryen::class.java) }
        val VERSION = "118"

//        init {
//            val library = NativeLibrary.getInstance("/usr/local/lib/libbinaryen.so")
//            Native.register(Binaryen::class.java, library)
//        }
    }

// functions:
fun BinaryenAbsFloat32(): BinaryenOp
fun BinaryenAbsFloat64(): BinaryenOp
fun BinaryenAbsVecF32x4(): BinaryenOp
fun BinaryenAbsVecF64x2(): BinaryenOp
fun BinaryenAbsVecI16x8(): BinaryenOp
fun BinaryenAbsVecI32x4(): BinaryenOp
fun BinaryenAbsVecI64x2(): BinaryenOp
fun BinaryenAbsVecI8x16(): BinaryenOp
fun BinaryenAddActiveElementSegment(module: BinaryenModuleRef, table: String, name: String, funcNames: Array<String>, numFuncNames: Int, offset: BinaryenExpressionRef): BinaryenElementSegmentRef
fun BinaryenAddCustomSection(module: BinaryenModuleRef, name: String, contents: String, contentsSize: Int)
fun BinaryenAddDataSegment(module: BinaryenModuleRef, segmentName: String, memoryName: String, segmentPassive: Boolean, segmentOffset: BinaryenExpressionRef, segmentData: String, segmentSize: Int)
fun BinaryenAddFloat32(): BinaryenOp
fun BinaryenAddFloat64(): BinaryenOp
fun BinaryenAddFunction(module: BinaryenModuleRef, name: String, params: BinaryenType, results: BinaryenType, varTypes: LongArray?, numVarTypes: Int, body: BinaryenExpressionRef): BinaryenFunctionRef
fun BinaryenAddFunctionExport(module: BinaryenModuleRef, internalName: String, externalName: String): BinaryenExportRef
fun BinaryenAddFunctionImport(module: BinaryenModuleRef, internalName: String, externalModuleName: String, externalBaseName: String, params: BinaryenType, results: BinaryenType)
fun BinaryenAddFunctionWithHeapType(module: BinaryenModuleRef, name: String, type: BinaryenHeapType, varTypes: LongArray?, numVarTypes: Int, body: BinaryenExpressionRef): BinaryenFunctionRef
fun BinaryenAddGlobal(module: BinaryenModuleRef, name: String, type: BinaryenType, mutable_: Boolean, init: BinaryenExpressionRef): BinaryenGlobalRef
fun BinaryenAddGlobalExport(module: BinaryenModuleRef, internalName: String, externalName: String): BinaryenExportRef
fun BinaryenAddGlobalImport(module: BinaryenModuleRef, internalName: String, externalModuleName: String, externalBaseName: String, globalType: BinaryenType, mutable_: Boolean)
fun BinaryenAddInt32(): BinaryenOp
fun BinaryenAddInt64(): BinaryenOp
fun BinaryenAddMemoryExport(module: BinaryenModuleRef, internalName: String, externalName: String): BinaryenExportRef
fun BinaryenAddMemoryImport(module: BinaryenModuleRef, internalName: String, externalModuleName: String, externalBaseName: String, shared: Byte)
fun BinaryenAddPassiveElementSegment(module: BinaryenModuleRef, name: String, funcNames: Array<String>, numFuncNames: Int): BinaryenElementSegmentRef
fun BinaryenAddSatSVecI16x8(): BinaryenOp
fun BinaryenAddSatSVecI8x16(): BinaryenOp
fun BinaryenAddSatUVecI16x8(): BinaryenOp
fun BinaryenAddSatUVecI8x16(): BinaryenOp
fun BinaryenAddTable(module: BinaryenModuleRef, table: String, initial: Int, maximum: Int, tableType: BinaryenType): BinaryenTableRef
fun BinaryenAddTableExport(module: BinaryenModuleRef, internalName: String, externalName: String): BinaryenExportRef
fun BinaryenAddTableImport(module: BinaryenModuleRef, internalName: String, externalModuleName: String, externalBaseName: String)
fun BinaryenAddTag(module: BinaryenModuleRef, name: String, params: BinaryenType, results: BinaryenType): BinaryenTagRef
fun BinaryenAddTagExport(module: BinaryenModuleRef, internalName: String, externalName: String): BinaryenExportRef
fun BinaryenAddTagImport(module: BinaryenModuleRef, internalName: String, externalModuleName: String, externalBaseName: String, params: BinaryenType, results: BinaryenType)
fun BinaryenAddVecF32x4(): BinaryenOp
fun BinaryenAddVecF64x2(): BinaryenOp
fun BinaryenAddVecI16x8(): BinaryenOp
fun BinaryenAddVecI32x4(): BinaryenOp
fun BinaryenAddVecI64x2(): BinaryenOp
fun BinaryenAddVecI8x16(): BinaryenOp
fun BinaryenAllTrueVecI16x8(): BinaryenOp
fun BinaryenAllTrueVecI32x4(): BinaryenOp
fun BinaryenAllTrueVecI64x2(): BinaryenOp
fun BinaryenAllTrueVecI8x16(): BinaryenOp
fun BinaryenAndInt32(): BinaryenOp
fun BinaryenAndInt64(): BinaryenOp
fun BinaryenAndNotVec128(): BinaryenOp
fun BinaryenAndVec128(): BinaryenOp
fun BinaryenAnyTrueVec128(): BinaryenOp
fun BinaryenAreColorsEnabled(): Boolean
fun BinaryenArrayCopy(module: BinaryenModuleRef, destRef: BinaryenExpressionRef, destIndex: BinaryenExpressionRef, srcRef: BinaryenExpressionRef, srcIndex: BinaryenExpressionRef, length: BinaryenExpressionRef): BinaryenExpressionRef
fun BinaryenArrayCopyGetDestIndex(expr: BinaryenExpressionRef): BinaryenExpressionRef
fun BinaryenArrayCopyGetDestRef(expr: BinaryenExpressionRef): BinaryenExpressionRef
fun BinaryenArrayCopyGetLength(expr: BinaryenExpressionRef): BinaryenExpressionRef
fun BinaryenArrayCopyGetSrcIndex(expr: BinaryenExpressionRef): BinaryenExpressionRef
fun BinaryenArrayCopyGetSrcRef(expr: BinaryenExpressionRef): BinaryenExpressionRef
fun BinaryenArrayCopyId(): BinaryenExpressionId
fun BinaryenArrayCopySetDestIndex(expr: BinaryenExpressionRef, destIndexExpr: BinaryenExpressionRef)
fun BinaryenArrayCopySetDestRef(expr: BinaryenExpressionRef, destRefExpr: BinaryenExpressionRef)
fun BinaryenArrayCopySetLength(expr: BinaryenExpressionRef, lengthExpr: BinaryenExpressionRef)
fun BinaryenArrayCopySetSrcIndex(expr: BinaryenExpressionRef, srcIndexExpr: BinaryenExpressionRef)
fun BinaryenArrayCopySetSrcRef(expr: BinaryenExpressionRef, srcRefExpr: BinaryenExpressionRef)
fun BinaryenArrayFillId(): BinaryenExpressionId
fun BinaryenArrayGet(module: BinaryenModuleRef, ref: BinaryenExpressionRef, index: BinaryenExpressionRef, type: BinaryenType, signed_: Boolean): BinaryenExpressionRef
fun BinaryenArrayGetGetIndex(expr: BinaryenExpressionRef): BinaryenExpressionRef
fun BinaryenArrayGetGetRef(expr: BinaryenExpressionRef): BinaryenExpressionRef
fun BinaryenArrayGetId(): BinaryenExpressionId
fun BinaryenArrayGetIsSigned(expr: BinaryenExpressionRef): Boolean
fun BinaryenArrayGetSetIndex(expr: BinaryenExpressionRef, indexExpr: BinaryenExpressionRef)
fun BinaryenArrayGetSetRef(expr: BinaryenExpressionRef, refExpr: BinaryenExpressionRef)
fun BinaryenArrayGetSetSigned(expr: BinaryenExpressionRef, signed_: Boolean)
fun BinaryenArrayInitDataId(): BinaryenExpressionId
fun BinaryenArrayInitElemId(): BinaryenExpressionId
fun BinaryenArrayLen(module: BinaryenModuleRef, ref: BinaryenExpressionRef): BinaryenExpressionRef
fun BinaryenArrayLenGetRef(expr: BinaryenExpressionRef): BinaryenExpressionRef
fun BinaryenArrayLenId(): BinaryenExpressionId
fun BinaryenArrayLenSetRef(expr: BinaryenExpressionRef, refExpr: BinaryenExpressionRef)
fun BinaryenArrayNew(module: BinaryenModuleRef, type: BinaryenHeapType, size: BinaryenExpressionRef, init: BinaryenExpressionRef): BinaryenExpressionRef
fun BinaryenArrayNewData(module: BinaryenModuleRef, type: BinaryenHeapType, name: String, offset: BinaryenExpressionRef, size: BinaryenExpressionRef): BinaryenExpressionRef
fun BinaryenArrayNewDataId(): BinaryenExpressionId
fun BinaryenArrayNewElemId(): BinaryenExpressionId
fun BinaryenArrayNewFixed(module: BinaryenModuleRef, type: BinaryenHeapType, values: Array<BinaryenExpressionRef>?, numValues: Int): BinaryenExpressionRef
fun BinaryenArrayNewFixedAppendValue(expr: BinaryenExpressionRef, valueExpr: BinaryenExpressionRef): Int
fun BinaryenArrayNewFixedGetNumValues(expr: BinaryenExpressionRef): Int
fun BinaryenArrayNewFixedGetValueAt(expr: BinaryenExpressionRef, index: Int): BinaryenExpressionRef
fun BinaryenArrayNewFixedId(): BinaryenExpressionId
fun BinaryenArrayNewFixedInsertValueAt(expr: BinaryenExpressionRef, index: Int, valueExpr: BinaryenExpressionRef)
fun BinaryenArrayNewFixedRemoveValueAt(expr: BinaryenExpressionRef, index: Int): BinaryenExpressionRef
fun BinaryenArrayNewFixedSetValueAt(expr: BinaryenExpressionRef, index: Int, valueExpr: BinaryenExpressionRef)
fun BinaryenArrayNewGetInit(expr: BinaryenExpressionRef): BinaryenExpressionRef
fun BinaryenArrayNewGetSize(expr: BinaryenExpressionRef): BinaryenExpressionRef
fun BinaryenArrayNewId(): BinaryenExpressionId
fun BinaryenArrayNewSetInit(expr: BinaryenExpressionRef, initExpr: BinaryenExpressionRef)
fun BinaryenArrayNewSetSize(expr: BinaryenExpressionRef, sizeExpr: BinaryenExpressionRef)
fun BinaryenArraySet(module: BinaryenModuleRef, ref: BinaryenExpressionRef, index: BinaryenExpressionRef, value: BinaryenExpressionRef): BinaryenExpressionRef
fun BinaryenArraySetGetIndex(expr: BinaryenExpressionRef): BinaryenExpressionRef
fun BinaryenArraySetGetRef(expr: BinaryenExpressionRef): BinaryenExpressionRef
fun BinaryenArraySetGetValue(expr: BinaryenExpressionRef): BinaryenExpressionRef
fun BinaryenArraySetId(): BinaryenExpressionId
fun BinaryenArraySetSetIndex(expr: BinaryenExpressionRef, indexExpr: BinaryenExpressionRef)
fun BinaryenArraySetSetRef(expr: BinaryenExpressionRef, refExpr: BinaryenExpressionRef)
fun BinaryenArraySetSetValue(expr: BinaryenExpressionRef, valueExpr: BinaryenExpressionRef)
fun BinaryenArrayTypeGetElementPackedType(heapType: BinaryenHeapType): BinaryenPackedType
fun BinaryenArrayTypeGetElementType(heapType: BinaryenHeapType): BinaryenType
fun BinaryenArrayTypeIsElementMutable(heapType: BinaryenHeapType): Boolean
fun BinaryenAtomicCmpxchg(module: BinaryenModuleRef, bytes: Int, offset: Int, ptr: BinaryenExpressionRef, expected: BinaryenExpressionRef, replacement: BinaryenExpressionRef, type: BinaryenType, memoryName: String): BinaryenExpressionRef
fun BinaryenAtomicCmpxchgGetBytes(expr: BinaryenExpressionRef): Int
fun BinaryenAtomicCmpxchgGetExpected(expr: BinaryenExpressionRef): BinaryenExpressionRef
fun BinaryenAtomicCmpxchgGetOffset(expr: BinaryenExpressionRef): Int
fun BinaryenAtomicCmpxchgGetPtr(expr: BinaryenExpressionRef): BinaryenExpressionRef
fun BinaryenAtomicCmpxchgGetReplacement(expr: BinaryenExpressionRef): BinaryenExpressionRef
fun BinaryenAtomicCmpxchgId(): BinaryenExpressionId
fun BinaryenAtomicCmpxchgSetBytes(expr: BinaryenExpressionRef, bytes: Int)
fun BinaryenAtomicCmpxchgSetExpected(expr: BinaryenExpressionRef, expectedExpr: BinaryenExpressionRef)
fun BinaryenAtomicCmpxchgSetOffset(expr: BinaryenExpressionRef, offset: Int)
fun BinaryenAtomicCmpxchgSetPtr(expr: BinaryenExpressionRef, ptrExpr: BinaryenExpressionRef)
fun BinaryenAtomicCmpxchgSetReplacement(expr: BinaryenExpressionRef, replacementExpr: BinaryenExpressionRef)
fun BinaryenAtomicFence(module: BinaryenModuleRef): BinaryenExpressionRef
fun BinaryenAtomicFenceGetOrder(expr: BinaryenExpressionRef): Byte
fun BinaryenAtomicFenceId(): BinaryenExpressionId
fun BinaryenAtomicFenceSetOrder(expr: BinaryenExpressionRef, order: Byte)
fun BinaryenAtomicLoad(module: BinaryenModuleRef, bytes: Int, offset: Int, type: BinaryenType, ptr: BinaryenExpressionRef, memoryName: String): BinaryenExpressionRef
fun BinaryenAtomicNotify(module: BinaryenModuleRef, ptr: BinaryenExpressionRef, notifyCount: BinaryenExpressionRef, memoryName: String): BinaryenExpressionRef
fun BinaryenAtomicNotifyGetNotifyCount(expr: BinaryenExpressionRef): BinaryenExpressionRef
fun BinaryenAtomicNotifyGetPtr(expr: BinaryenExpressionRef): BinaryenExpressionRef
fun BinaryenAtomicNotifyId(): BinaryenExpressionId
fun BinaryenAtomicNotifySetNotifyCount(expr: BinaryenExpressionRef, notifyCountExpr: BinaryenExpressionRef)
fun BinaryenAtomicNotifySetPtr(expr: BinaryenExpressionRef, ptrExpr: BinaryenExpressionRef)
fun BinaryenAtomicRMW(module: BinaryenModuleRef, op: BinaryenOp, bytes: Int, offset: Int, ptr: BinaryenExpressionRef, value: BinaryenExpressionRef, type: BinaryenType, memoryName: String): BinaryenExpressionRef
fun BinaryenAtomicRMWAdd(): BinaryenOp
fun BinaryenAtomicRMWAnd(): BinaryenOp
fun BinaryenAtomicRMWGetBytes(expr: BinaryenExpressionRef): Int
fun BinaryenAtomicRMWGetOffset(expr: BinaryenExpressionRef): Int
fun BinaryenAtomicRMWGetOp(expr: BinaryenExpressionRef): BinaryenOp
fun BinaryenAtomicRMWGetPtr(expr: BinaryenExpressionRef): BinaryenExpressionRef
fun BinaryenAtomicRMWGetValue(expr: BinaryenExpressionRef): BinaryenExpressionRef
fun BinaryenAtomicRMWId(): BinaryenExpressionId
fun BinaryenAtomicRMWOr(): BinaryenOp
fun BinaryenAtomicRMWSetBytes(expr: BinaryenExpressionRef, bytes: Int)
fun BinaryenAtomicRMWSetOffset(expr: BinaryenExpressionRef, offset: Int)
fun BinaryenAtomicRMWSetOp(expr: BinaryenExpressionRef, op: BinaryenOp)
fun BinaryenAtomicRMWSetPtr(expr: BinaryenExpressionRef, ptrExpr: BinaryenExpressionRef)
fun BinaryenAtomicRMWSetValue(expr: BinaryenExpressionRef, valueExpr: BinaryenExpressionRef)
fun BinaryenAtomicRMWSub(): BinaryenOp
fun BinaryenAtomicRMWXchg(): BinaryenOp
fun BinaryenAtomicRMWXor(): BinaryenOp
fun BinaryenAtomicStore(module: BinaryenModuleRef, bytes: Int, offset: Int, ptr: BinaryenExpressionRef, value: BinaryenExpressionRef, type: BinaryenType, memoryName: String): BinaryenExpressionRef
fun BinaryenAtomicWait(module: BinaryenModuleRef, ptr: BinaryenExpressionRef, expected: BinaryenExpressionRef, timeout: BinaryenExpressionRef, type: BinaryenType, memoryName: String): BinaryenExpressionRef
fun BinaryenAtomicWaitGetExpected(expr: BinaryenExpressionRef): BinaryenExpressionRef
fun BinaryenAtomicWaitGetExpectedType(expr: BinaryenExpressionRef): BinaryenType
fun BinaryenAtomicWaitGetPtr(expr: BinaryenExpressionRef): BinaryenExpressionRef
fun BinaryenAtomicWaitGetTimeout(expr: BinaryenExpressionRef): BinaryenExpressionRef
fun BinaryenAtomicWaitId(): BinaryenExpressionId
fun BinaryenAtomicWaitSetExpected(expr: BinaryenExpressionRef, expectedExpr: BinaryenExpressionRef)
fun BinaryenAtomicWaitSetExpectedType(expr: BinaryenExpressionRef, expectedType: BinaryenType)
fun BinaryenAtomicWaitSetPtr(expr: BinaryenExpressionRef, ptrExpr: BinaryenExpressionRef)
fun BinaryenAtomicWaitSetTimeout(expr: BinaryenExpressionRef, timeoutExpr: BinaryenExpressionRef)
fun BinaryenAvgrUVecI16x8(): BinaryenOp
fun BinaryenAvgrUVecI8x16(): BinaryenOp
fun BinaryenBinary(module: BinaryenModuleRef, op: BinaryenOp, left: BinaryenExpressionRef, right: BinaryenExpressionRef): BinaryenExpressionRef
fun BinaryenBinaryGetLeft(expr: BinaryenExpressionRef): BinaryenExpressionRef
fun BinaryenBinaryGetOp(expr: BinaryenExpressionRef): BinaryenOp
fun BinaryenBinaryGetRight(expr: BinaryenExpressionRef): BinaryenExpressionRef
fun BinaryenBinaryId(): BinaryenExpressionId
fun BinaryenBinarySetLeft(expr: BinaryenExpressionRef, leftExpr: BinaryenExpressionRef)
fun BinaryenBinarySetOp(expr: BinaryenExpressionRef, op: BinaryenOp)
fun BinaryenBinarySetRight(expr: BinaryenExpressionRef, rightExpr: BinaryenExpressionRef)
fun BinaryenBitmaskVecI16x8(): BinaryenOp
fun BinaryenBitmaskVecI32x4(): BinaryenOp
fun BinaryenBitmaskVecI64x2(): BinaryenOp
fun BinaryenBitmaskVecI8x16(): BinaryenOp
fun BinaryenBitselectVec128(): BinaryenOp
fun BinaryenBlock(module: BinaryenModuleRef, name: String, children: Array<BinaryenExpressionRef>?, numChildren: Int, type: BinaryenType): BinaryenExpressionRef
fun BinaryenBlockAppendChild(expr: BinaryenExpressionRef, childExpr: BinaryenExpressionRef): Int
fun BinaryenBlockGetChildAt(expr: BinaryenExpressionRef, index: Int): BinaryenExpressionRef
fun BinaryenBlockGetName(expr: BinaryenExpressionRef): String
fun BinaryenBlockGetNumChildren(expr: BinaryenExpressionRef): Int
fun BinaryenBlockId(): BinaryenExpressionId
fun BinaryenBlockInsertChildAt(expr: BinaryenExpressionRef, index: Int, childExpr: BinaryenExpressionRef)
fun BinaryenBlockRemoveChildAt(expr: BinaryenExpressionRef, index: Int): BinaryenExpressionRef
fun BinaryenBlockSetChildAt(expr: BinaryenExpressionRef, index: Int, childExpr: BinaryenExpressionRef)
fun BinaryenBlockSetName(expr: BinaryenExpressionRef, name: String)
fun BinaryenBrOn(module: BinaryenModuleRef, op: BinaryenOp, name: String, ref: BinaryenExpressionRef, castType: BinaryenType): BinaryenExpressionRef
fun BinaryenBrOnCast(): BinaryenOp
fun BinaryenBrOnCastFail(): BinaryenOp
fun BinaryenBrOnGetCastType(expr: BinaryenExpressionRef): BinaryenType
fun BinaryenBrOnGetName(expr: BinaryenExpressionRef): String
fun BinaryenBrOnGetOp(expr: BinaryenExpressionRef): BinaryenOp
fun BinaryenBrOnGetRef(expr: BinaryenExpressionRef): BinaryenExpressionRef
fun BinaryenBrOnId(): BinaryenExpressionId
fun BinaryenBrOnNonNull(): BinaryenOp
fun BinaryenBrOnNull(): BinaryenOp
fun BinaryenBrOnSetCastType(expr: BinaryenExpressionRef, castType: BinaryenType)
fun BinaryenBrOnSetName(expr: BinaryenExpressionRef, nameStr: String)
fun BinaryenBrOnSetOp(expr: BinaryenExpressionRef, op: BinaryenOp)
fun BinaryenBrOnSetRef(expr: BinaryenExpressionRef, refExpr: BinaryenExpressionRef)
fun BinaryenBreak(module: BinaryenModuleRef, name: String, condition: BinaryenExpressionRef, value: BinaryenExpressionRef): BinaryenExpressionRef
fun BinaryenBreakGetCondition(expr: BinaryenExpressionRef): BinaryenExpressionRef
fun BinaryenBreakGetName(expr: BinaryenExpressionRef): String
fun BinaryenBreakGetValue(expr: BinaryenExpressionRef): BinaryenExpressionRef
fun BinaryenBreakId(): BinaryenExpressionId
fun BinaryenBreakSetCondition(expr: BinaryenExpressionRef, condExpr: BinaryenExpressionRef)
fun BinaryenBreakSetName(expr: BinaryenExpressionRef, name: String)
fun BinaryenBreakSetValue(expr: BinaryenExpressionRef, valueExpr: BinaryenExpressionRef)
fun BinaryenCall(module: BinaryenModuleRef, target: String, operands: Array<BinaryenExpressionRef>?, numOperands: Int, returnType: BinaryenType): BinaryenExpressionRef
fun BinaryenCallAppendOperand(expr: BinaryenExpressionRef, operandExpr: BinaryenExpressionRef): Int
fun BinaryenCallGetNumOperands(expr: BinaryenExpressionRef): Int
fun BinaryenCallGetOperandAt(expr: BinaryenExpressionRef, index: Int): BinaryenExpressionRef
fun BinaryenCallGetTarget(expr: BinaryenExpressionRef): String
fun BinaryenCallId(): BinaryenExpressionId
fun BinaryenCallIndirect(module: BinaryenModuleRef, table: String, target: BinaryenExpressionRef, operands: Array<BinaryenExpressionRef>?, numOperands: Int, params: BinaryenType, results: BinaryenType): BinaryenExpressionRef
fun BinaryenCallIndirectAppendOperand(expr: BinaryenExpressionRef, operandExpr: BinaryenExpressionRef): Int
fun BinaryenCallIndirectGetNumOperands(expr: BinaryenExpressionRef): Int
fun BinaryenCallIndirectGetOperandAt(expr: BinaryenExpressionRef, index: Int): BinaryenExpressionRef
fun BinaryenCallIndirectGetParams(expr: BinaryenExpressionRef): BinaryenType
fun BinaryenCallIndirectGetResults(expr: BinaryenExpressionRef): BinaryenType
fun BinaryenCallIndirectGetTable(expr: BinaryenExpressionRef): String
fun BinaryenCallIndirectGetTarget(expr: BinaryenExpressionRef): BinaryenExpressionRef
fun BinaryenCallIndirectId(): BinaryenExpressionId
fun BinaryenCallIndirectInsertOperandAt(expr: BinaryenExpressionRef, index: Int, operandExpr: BinaryenExpressionRef)
fun BinaryenCallIndirectIsReturn(expr: BinaryenExpressionRef): Boolean
fun BinaryenCallIndirectRemoveOperandAt(expr: BinaryenExpressionRef, index: Int): BinaryenExpressionRef
fun BinaryenCallIndirectSetOperandAt(expr: BinaryenExpressionRef, index: Int, operandExpr: BinaryenExpressionRef)
fun BinaryenCallIndirectSetParams(expr: BinaryenExpressionRef, params: BinaryenType)
fun BinaryenCallIndirectSetResults(expr: BinaryenExpressionRef, params: BinaryenType)
fun BinaryenCallIndirectSetReturn(expr: BinaryenExpressionRef, isReturn: Boolean)
fun BinaryenCallIndirectSetTable(expr: BinaryenExpressionRef, table: String)
fun BinaryenCallIndirectSetTarget(expr: BinaryenExpressionRef, targetExpr: BinaryenExpressionRef)
fun BinaryenCallInsertOperandAt(expr: BinaryenExpressionRef, index: Int, operandExpr: BinaryenExpressionRef)
fun BinaryenCallIsReturn(expr: BinaryenExpressionRef): Boolean
fun BinaryenCallRef(module: BinaryenModuleRef, target: BinaryenExpressionRef, operands: Array<BinaryenExpressionRef>?, numOperands: Int, type: BinaryenType, isReturn: Boolean): BinaryenExpressionRef
fun BinaryenCallRefAppendOperand(expr: BinaryenExpressionRef, operandExpr: BinaryenExpressionRef): Int
fun BinaryenCallRefGetNumOperands(expr: BinaryenExpressionRef): Int
fun BinaryenCallRefGetOperandAt(expr: BinaryenExpressionRef, index: Int): BinaryenExpressionRef
fun BinaryenCallRefGetTarget(expr: BinaryenExpressionRef): BinaryenExpressionRef
fun BinaryenCallRefId(): BinaryenExpressionId
fun BinaryenCallRefInsertOperandAt(expr: BinaryenExpressionRef, index: Int, operandExpr: BinaryenExpressionRef)
fun BinaryenCallRefIsReturn(expr: BinaryenExpressionRef): Boolean
fun BinaryenCallRefRemoveOperandAt(expr: BinaryenExpressionRef, index: Int): BinaryenExpressionRef
fun BinaryenCallRefSetOperandAt(expr: BinaryenExpressionRef, index: Int, operandExpr: BinaryenExpressionRef)
fun BinaryenCallRefSetReturn(expr: BinaryenExpressionRef, isReturn: Boolean)
fun BinaryenCallRefSetTarget(expr: BinaryenExpressionRef, targetExpr: BinaryenExpressionRef)
fun BinaryenCallRemoveOperandAt(expr: BinaryenExpressionRef, index: Int): BinaryenExpressionRef
fun BinaryenCallSetOperandAt(expr: BinaryenExpressionRef, index: Int, operandExpr: BinaryenExpressionRef)
fun BinaryenCallSetReturn(expr: BinaryenExpressionRef, isReturn: Boolean)
fun BinaryenCallSetTarget(expr: BinaryenExpressionRef, target: String)
fun BinaryenCeilFloat32(): BinaryenOp
fun BinaryenCeilFloat64(): BinaryenOp
fun BinaryenCeilVecF32x4(): BinaryenOp
fun BinaryenCeilVecF64x2(): BinaryenOp
fun BinaryenClearPassArguments()
fun BinaryenClzInt32(): BinaryenOp
fun BinaryenClzInt64(): BinaryenOp
fun BinaryenConst(module: BinaryenModuleRef, value: BinaryenLiteral): BinaryenExpressionRef
fun BinaryenConstGetValueF32(expr: BinaryenExpressionRef): Float
fun BinaryenConstGetValueF64(expr: BinaryenExpressionRef): Double
fun BinaryenConstGetValueI32(expr: BinaryenExpressionRef): Int
fun BinaryenConstGetValueI64(expr: BinaryenExpressionRef): Long
fun BinaryenConstGetValueI64High(expr: BinaryenExpressionRef): Int
fun BinaryenConstGetValueI64Low(expr: BinaryenExpressionRef): Int
fun BinaryenConstGetValueV128(expr: BinaryenExpressionRef, out: ByteArray?)
fun BinaryenConstId(): BinaryenExpressionId
fun BinaryenConstSetValueF32(expr: BinaryenExpressionRef, value: Float)
fun BinaryenConstSetValueF64(expr: BinaryenExpressionRef, value: Double)
fun BinaryenConstSetValueI32(expr: BinaryenExpressionRef, value: Int)
fun BinaryenConstSetValueI64(expr: BinaryenExpressionRef, value: Long)
fun BinaryenConstSetValueI64High(expr: BinaryenExpressionRef, valueHigh: Int)
fun BinaryenConstSetValueI64Low(expr: BinaryenExpressionRef, valueLow: Int)
fun BinaryenConstSetValueV128(expr: BinaryenExpressionRef, value: Byte)
fun BinaryenContBindId(): BinaryenExpressionId
fun BinaryenContNewId(): BinaryenExpressionId
fun BinaryenConvertLowSVecI32x4ToVecF64x2(): BinaryenOp
fun BinaryenConvertLowUVecI32x4ToVecF64x2(): BinaryenOp
fun BinaryenConvertSInt32ToFloat32(): BinaryenOp
fun BinaryenConvertSInt32ToFloat64(): BinaryenOp
fun BinaryenConvertSInt64ToFloat32(): BinaryenOp
fun BinaryenConvertSInt64ToFloat64(): BinaryenOp
fun BinaryenConvertSVecI32x4ToVecF32x4(): BinaryenOp
fun BinaryenConvertUInt32ToFloat32(): BinaryenOp
fun BinaryenConvertUInt32ToFloat64(): BinaryenOp
fun BinaryenConvertUInt64ToFloat32(): BinaryenOp
fun BinaryenConvertUInt64ToFloat64(): BinaryenOp
fun BinaryenConvertUVecI32x4ToVecF32x4(): BinaryenOp
fun BinaryenCopyMemorySegmentData(module: BinaryenModuleRef, segmentName: String, buffer: String)
fun BinaryenCopySignFloat32(): BinaryenOp
fun BinaryenCopySignFloat64(): BinaryenOp
fun BinaryenCtzInt32(): BinaryenOp
fun BinaryenCtzInt64(): BinaryenOp
fun BinaryenDataDrop(module: BinaryenModuleRef, segment: String): BinaryenExpressionRef
fun BinaryenDataDropGetSegment(expr: BinaryenExpressionRef): String
fun BinaryenDataDropId(): BinaryenExpressionId
fun BinaryenDataDropSetSegment(expr: BinaryenExpressionRef, segment: String)
fun BinaryenDemoteFloat64(): BinaryenOp
fun BinaryenDemoteZeroVecF64x2ToVecF32x4(): BinaryenOp
fun BinaryenDivFloat32(): BinaryenOp
fun BinaryenDivFloat64(): BinaryenOp
fun BinaryenDivSInt32(): BinaryenOp
fun BinaryenDivSInt64(): BinaryenOp
fun BinaryenDivUInt32(): BinaryenOp
fun BinaryenDivUInt64(): BinaryenOp
fun BinaryenDivVecF32x4(): BinaryenOp
fun BinaryenDivVecF64x2(): BinaryenOp
fun BinaryenDotI8x16I7x16AddSToVecI32x4(): BinaryenOp
fun BinaryenDotI8x16I7x16SToVecI16x8(): BinaryenOp
fun BinaryenDotSVecI16x8ToVecI32x4(): BinaryenOp
fun BinaryenDrop(module: BinaryenModuleRef, value: BinaryenExpressionRef): BinaryenExpressionRef
fun BinaryenDropGetValue(expr: BinaryenExpressionRef): BinaryenExpressionRef
fun BinaryenDropId(): BinaryenExpressionId
fun BinaryenDropSetValue(expr: BinaryenExpressionRef, valueExpr: BinaryenExpressionRef)
fun BinaryenElementSegmentGetData(elem: BinaryenElementSegmentRef, dataId: Int): String
fun BinaryenElementSegmentGetLength(elem: BinaryenElementSegmentRef): Int
fun BinaryenElementSegmentGetName(elem: BinaryenElementSegmentRef): String
fun BinaryenElementSegmentGetOffset(elem: BinaryenElementSegmentRef): BinaryenExpressionRef
fun BinaryenElementSegmentGetTable(elem: BinaryenElementSegmentRef): String
fun BinaryenElementSegmentIsPassive(elem: BinaryenElementSegmentRef): Boolean
fun BinaryenElementSegmentSetName(elem: BinaryenElementSegmentRef, name: String)
fun BinaryenElementSegmentSetTable(elem: BinaryenElementSegmentRef, table: String)
fun BinaryenEqFloat32(): BinaryenOp
fun BinaryenEqFloat64(): BinaryenOp
fun BinaryenEqInt32(): BinaryenOp
fun BinaryenEqInt64(): BinaryenOp
fun BinaryenEqVecF32x4(): BinaryenOp
fun BinaryenEqVecF64x2(): BinaryenOp
fun BinaryenEqVecI16x8(): BinaryenOp
fun BinaryenEqVecI32x4(): BinaryenOp
fun BinaryenEqVecI64x2(): BinaryenOp
fun BinaryenEqVecI8x16(): BinaryenOp
fun BinaryenEqZInt32(): BinaryenOp
fun BinaryenEqZInt64(): BinaryenOp
fun BinaryenExportGetKind(export_: BinaryenExportRef): BinaryenExternalKind
fun BinaryenExportGetName(export_: BinaryenExportRef): String
fun BinaryenExportGetValue(export_: BinaryenExportRef): String
fun BinaryenExpressionCopy(expr: BinaryenExpressionRef, module: BinaryenModuleRef): BinaryenExpressionRef
fun BinaryenExpressionFinalize(expr: BinaryenExpressionRef)
fun BinaryenExpressionGetId(expr: BinaryenExpressionRef): BinaryenExpressionId
fun BinaryenExpressionGetSideEffects(expr: BinaryenExpressionRef, module: BinaryenModuleRef): BinaryenSideEffects
fun BinaryenExpressionGetType(expr: BinaryenExpressionRef): BinaryenType
fun BinaryenExpressionPrint(expr: BinaryenExpressionRef)
fun BinaryenExpressionSetType(expr: BinaryenExpressionRef, type: BinaryenType)
fun BinaryenExtAddPairwiseSVecI16x8ToI32x4(): BinaryenOp
fun BinaryenExtAddPairwiseSVecI8x16ToI16x8(): BinaryenOp
fun BinaryenExtAddPairwiseUVecI16x8ToI32x4(): BinaryenOp
fun BinaryenExtAddPairwiseUVecI8x16ToI16x8(): BinaryenOp
fun BinaryenExtMulHighSVecI16x8(): BinaryenOp
fun BinaryenExtMulHighSVecI32x4(): BinaryenOp
fun BinaryenExtMulHighSVecI64x2(): BinaryenOp
fun BinaryenExtMulHighUVecI16x8(): BinaryenOp
fun BinaryenExtMulHighUVecI32x4(): BinaryenOp
fun BinaryenExtMulHighUVecI64x2(): BinaryenOp
fun BinaryenExtMulLowSVecI16x8(): BinaryenOp
fun BinaryenExtMulLowSVecI32x4(): BinaryenOp
fun BinaryenExtMulLowSVecI64x2(): BinaryenOp
fun BinaryenExtMulLowUVecI16x8(): BinaryenOp
fun BinaryenExtMulLowUVecI32x4(): BinaryenOp
fun BinaryenExtMulLowUVecI64x2(): BinaryenOp
fun BinaryenExtendHighSVecI16x8ToVecI32x4(): BinaryenOp
fun BinaryenExtendHighSVecI32x4ToVecI64x2(): BinaryenOp
fun BinaryenExtendHighSVecI8x16ToVecI16x8(): BinaryenOp
fun BinaryenExtendHighUVecI16x8ToVecI32x4(): BinaryenOp
fun BinaryenExtendHighUVecI32x4ToVecI64x2(): BinaryenOp
fun BinaryenExtendHighUVecI8x16ToVecI16x8(): BinaryenOp
fun BinaryenExtendLowSVecI16x8ToVecI32x4(): BinaryenOp
fun BinaryenExtendLowSVecI32x4ToVecI64x2(): BinaryenOp
fun BinaryenExtendLowSVecI8x16ToVecI16x8(): BinaryenOp
fun BinaryenExtendLowUVecI16x8ToVecI32x4(): BinaryenOp
fun BinaryenExtendLowUVecI32x4ToVecI64x2(): BinaryenOp
fun BinaryenExtendLowUVecI8x16ToVecI16x8(): BinaryenOp
fun BinaryenExtendS16Int32(): BinaryenOp
fun BinaryenExtendS16Int64(): BinaryenOp
fun BinaryenExtendS32Int64(): BinaryenOp
fun BinaryenExtendS8Int32(): BinaryenOp
fun BinaryenExtendS8Int64(): BinaryenOp
fun BinaryenExtendSInt32(): BinaryenOp
fun BinaryenExtendUInt32(): BinaryenOp
fun BinaryenExternalFunction(): BinaryenExternalKind
fun BinaryenExternalGlobal(): BinaryenExternalKind
fun BinaryenExternalMemory(): BinaryenExternalKind
fun BinaryenExternalTable(): BinaryenExternalKind
fun BinaryenExternalTag(): BinaryenExternalKind
fun BinaryenExtractLaneSVecI16x8(): BinaryenOp
fun BinaryenExtractLaneSVecI8x16(): BinaryenOp
fun BinaryenExtractLaneUVecI16x8(): BinaryenOp
fun BinaryenExtractLaneUVecI8x16(): BinaryenOp
fun BinaryenExtractLaneVecF32x4(): BinaryenOp
fun BinaryenExtractLaneVecF64x2(): BinaryenOp
fun BinaryenExtractLaneVecI32x4(): BinaryenOp
fun BinaryenExtractLaneVecI64x2(): BinaryenOp
fun BinaryenFeatureAll(): BinaryenFeatures
fun BinaryenFeatureAtomics(): BinaryenFeatures
fun BinaryenFeatureBulkMemory(): BinaryenFeatures
fun BinaryenFeatureExceptionHandling(): BinaryenFeatures
fun BinaryenFeatureExtendedConst(): BinaryenFeatures
fun BinaryenFeatureGC(): BinaryenFeatures
fun BinaryenFeatureMVP(): BinaryenFeatures
fun BinaryenFeatureMemory64(): BinaryenFeatures
fun BinaryenFeatureMultiMemory(): BinaryenFeatures
fun BinaryenFeatureMultivalue(): BinaryenFeatures
fun BinaryenFeatureMutableGlobals(): BinaryenFeatures
fun BinaryenFeatureNontrappingFPToInt(): BinaryenFeatures
fun BinaryenFeatureReferenceTypes(): BinaryenFeatures
fun BinaryenFeatureRelaxedSIMD(): BinaryenFeatures
fun BinaryenFeatureSIMD128(): BinaryenFeatures
fun BinaryenFeatureSignExt(): BinaryenFeatures
fun BinaryenFeatureStrings(): BinaryenFeatures
fun BinaryenFeatureTailCall(): BinaryenFeatures
fun BinaryenFloorFloat32(): BinaryenOp
fun BinaryenFloorFloat64(): BinaryenOp
fun BinaryenFloorVecF32x4(): BinaryenOp
fun BinaryenFloorVecF64x2(): BinaryenOp
fun BinaryenFunctionAddVar(func: BinaryenFunctionRef, type: BinaryenType): Int
fun BinaryenFunctionGetBody(func: BinaryenFunctionRef): BinaryenExpressionRef
fun BinaryenFunctionGetLocalName(func: BinaryenFunctionRef, index: Int): String
fun BinaryenFunctionGetName(func: BinaryenFunctionRef): String
fun BinaryenFunctionGetNumLocals(func: BinaryenFunctionRef): Int
fun BinaryenFunctionGetNumVars(func: BinaryenFunctionRef): Int
fun BinaryenFunctionGetParams(func: BinaryenFunctionRef): BinaryenType
fun BinaryenFunctionGetResults(func: BinaryenFunctionRef): BinaryenType
fun BinaryenFunctionGetVar(func: BinaryenFunctionRef, index: Int): BinaryenType
fun BinaryenFunctionHasLocalName(func: BinaryenFunctionRef, index: Int): Boolean
fun BinaryenFunctionImportGetBase(import: BinaryenFunctionRef): String
fun BinaryenFunctionImportGetModule(import: BinaryenFunctionRef): String
fun BinaryenFunctionOptimize(func: BinaryenFunctionRef, module: BinaryenModuleRef)
fun BinaryenFunctionRunPasses(func: BinaryenFunctionRef, module: BinaryenModuleRef, passes: Array<String>, numPasses: Int)
fun BinaryenFunctionSetBody(func: BinaryenFunctionRef, body: BinaryenExpressionRef)
fun BinaryenFunctionSetDebugLocation(func: BinaryenFunctionRef, expr: BinaryenExpressionRef, fileIndex: Int, lineNumber: Int, columnNumber: Int)
fun BinaryenFunctionSetLocalName(func: BinaryenFunctionRef, index: Int, name: String)
fun BinaryenGeFloat32(): BinaryenOp
fun BinaryenGeFloat64(): BinaryenOp
fun BinaryenGeSInt32(): BinaryenOp
fun BinaryenGeSInt64(): BinaryenOp
fun BinaryenGeSVecI16x8(): BinaryenOp
fun BinaryenGeSVecI32x4(): BinaryenOp
fun BinaryenGeSVecI64x2(): BinaryenOp
fun BinaryenGeSVecI8x16(): BinaryenOp
fun BinaryenGeUInt32(): BinaryenOp
fun BinaryenGeUInt64(): BinaryenOp
fun BinaryenGeUVecI16x8(): BinaryenOp
fun BinaryenGeUVecI32x4(): BinaryenOp
fun BinaryenGeUVecI8x16(): BinaryenOp
fun BinaryenGeVecF32x4(): BinaryenOp
fun BinaryenGeVecF64x2(): BinaryenOp
fun BinaryenGetAllowInliningFunctionsWithLoops(): Boolean
fun BinaryenGetAlwaysInlineMaxSize(): Int
fun BinaryenGetDebugInfo(): Boolean
fun BinaryenGetElementSegment(module: BinaryenModuleRef, name: String): BinaryenElementSegmentRef
fun BinaryenGetElementSegmentByIndex(module: BinaryenModuleRef, index: Int): BinaryenElementSegmentRef
fun BinaryenGetExport(module: BinaryenModuleRef, externalName: String): BinaryenExportRef
fun BinaryenGetExportByIndex(module: BinaryenModuleRef, index: Int): BinaryenExportRef
fun BinaryenGetFastMath(): Boolean
fun BinaryenGetFlexibleInlineMaxSize(): Int
fun BinaryenGetFunction(module: BinaryenModuleRef, name: String): BinaryenFunctionRef
fun BinaryenGetFunctionByIndex(module: BinaryenModuleRef, index: Int): BinaryenFunctionRef
fun BinaryenGetGlobal(module: BinaryenModuleRef, name: String): BinaryenGlobalRef
fun BinaryenGetGlobalByIndex(module: BinaryenModuleRef, index: Int): BinaryenGlobalRef
fun BinaryenGetLowMemoryUnused(): Boolean
fun BinaryenGetMemorySegmentByteLength(module: BinaryenModuleRef, segmentName: String): Int
fun BinaryenGetMemorySegmentByteOffset(module: BinaryenModuleRef, segmentName: String): Int
fun BinaryenGetMemorySegmentPassive(module: BinaryenModuleRef, segmentName: String): Boolean
fun BinaryenGetNumElementSegments(module: BinaryenModuleRef): Int
fun BinaryenGetNumExports(module: BinaryenModuleRef): Int
fun BinaryenGetNumFunctions(module: BinaryenModuleRef): Int
fun BinaryenGetNumGlobals(module: BinaryenModuleRef): Int
fun BinaryenGetNumMemorySegments(module: BinaryenModuleRef): Int
fun BinaryenGetNumTables(module: BinaryenModuleRef): Int
fun BinaryenGetOneCallerInlineMaxSize(): Int
fun BinaryenGetOptimizeLevel(): Int
fun BinaryenGetPassArgument(name: String): String
fun BinaryenGetShrinkLevel(): Int
fun BinaryenGetTable(module: BinaryenModuleRef, name: String): BinaryenTableRef
fun BinaryenGetTableByIndex(module: BinaryenModuleRef, index: Int): BinaryenTableRef
fun BinaryenGetTag(module: BinaryenModuleRef, name: String): BinaryenTagRef
fun BinaryenGetZeroFilledMemory(): Boolean
fun BinaryenGlobalGet(module: BinaryenModuleRef, name: String, type: BinaryenType): BinaryenExpressionRef
fun BinaryenGlobalGetGetName(expr: BinaryenExpressionRef): String
fun BinaryenGlobalGetId(): BinaryenExpressionId
fun BinaryenGlobalGetInitExpr(global: BinaryenGlobalRef): BinaryenExpressionRef
fun BinaryenGlobalGetName(global: BinaryenGlobalRef): String
fun BinaryenGlobalGetSetName(expr: BinaryenExpressionRef, name: String)
fun BinaryenGlobalGetType(global: BinaryenGlobalRef): BinaryenType
fun BinaryenGlobalImportGetBase(import: BinaryenGlobalRef): String
fun BinaryenGlobalImportGetModule(import: BinaryenGlobalRef): String
fun BinaryenGlobalIsMutable(global: BinaryenGlobalRef): Boolean
fun BinaryenGlobalSet(module: BinaryenModuleRef, name: String, value: BinaryenExpressionRef): BinaryenExpressionRef
fun BinaryenGlobalSetGetName(expr: BinaryenExpressionRef): String
fun BinaryenGlobalSetGetValue(expr: BinaryenExpressionRef): BinaryenExpressionRef
fun BinaryenGlobalSetId(): BinaryenExpressionId
fun BinaryenGlobalSetSetName(expr: BinaryenExpressionRef, name: String)
fun BinaryenGlobalSetSetValue(expr: BinaryenExpressionRef, valueExpr: BinaryenExpressionRef)
fun BinaryenGtFloat32(): BinaryenOp
fun BinaryenGtFloat64(): BinaryenOp
fun BinaryenGtSInt32(): BinaryenOp
fun BinaryenGtSInt64(): BinaryenOp
fun BinaryenGtSVecI16x8(): BinaryenOp
fun BinaryenGtSVecI32x4(): BinaryenOp
fun BinaryenGtSVecI64x2(): BinaryenOp
fun BinaryenGtSVecI8x16(): BinaryenOp
fun BinaryenGtUInt32(): BinaryenOp
fun BinaryenGtUInt64(): BinaryenOp
fun BinaryenGtUVecI16x8(): BinaryenOp
fun BinaryenGtUVecI32x4(): BinaryenOp
fun BinaryenGtUVecI8x16(): BinaryenOp
fun BinaryenGtVecF32x4(): BinaryenOp
fun BinaryenGtVecF64x2(): BinaryenOp
fun BinaryenHasMemory(module: BinaryenModuleRef): Boolean
fun BinaryenHeapTypeAny(): BinaryenHeapType
fun BinaryenHeapTypeArray(): BinaryenHeapType
fun BinaryenHeapTypeEq(): BinaryenHeapType
fun BinaryenHeapTypeExt(): BinaryenHeapType
fun BinaryenHeapTypeFunc(): BinaryenHeapType
fun BinaryenHeapTypeGetBottom(heapType: BinaryenHeapType): BinaryenHeapType
fun BinaryenHeapTypeI31(): BinaryenHeapType
fun BinaryenHeapTypeIsArray(heapType: BinaryenHeapType): Boolean
fun BinaryenHeapTypeIsBasic(heapType: BinaryenHeapType): Boolean
fun BinaryenHeapTypeIsBottom(heapType: BinaryenHeapType): Boolean
fun BinaryenHeapTypeIsSignature(heapType: BinaryenHeapType): Boolean
fun BinaryenHeapTypeIsStruct(heapType: BinaryenHeapType): Boolean
fun BinaryenHeapTypeIsSubType(left: BinaryenHeapType, right: BinaryenHeapType): Boolean
fun BinaryenHeapTypeNoext(): BinaryenHeapType
fun BinaryenHeapTypeNofunc(): BinaryenHeapType
fun BinaryenHeapTypeNone(): BinaryenHeapType
fun BinaryenHeapTypeString(): BinaryenHeapType
fun BinaryenHeapTypeStruct(): BinaryenHeapType
fun BinaryenI31Get(module: BinaryenModuleRef, i31: BinaryenExpressionRef, signed_: Boolean): BinaryenExpressionRef
fun BinaryenI31GetGetI31(expr: BinaryenExpressionRef): BinaryenExpressionRef
fun BinaryenI31GetId(): BinaryenExpressionId
fun BinaryenI31GetIsSigned(expr: BinaryenExpressionRef): Boolean
fun BinaryenI31GetSetI31(expr: BinaryenExpressionRef, i31Expr: BinaryenExpressionRef)
fun BinaryenI31GetSetSigned(expr: BinaryenExpressionRef, signed_: Boolean)
fun BinaryenIf(module: BinaryenModuleRef, condition: BinaryenExpressionRef, ifTrue: BinaryenExpressionRef, ifFalse: BinaryenExpressionRef): BinaryenExpressionRef
fun BinaryenIfGetCondition(expr: BinaryenExpressionRef): BinaryenExpressionRef
fun BinaryenIfGetIfFalse(expr: BinaryenExpressionRef): BinaryenExpressionRef
fun BinaryenIfGetIfTrue(expr: BinaryenExpressionRef): BinaryenExpressionRef
fun BinaryenIfId(): BinaryenExpressionId
fun BinaryenIfSetCondition(expr: BinaryenExpressionRef, condExpr: BinaryenExpressionRef)
fun BinaryenIfSetIfFalse(expr: BinaryenExpressionRef, ifFalseExpr: BinaryenExpressionRef)
fun BinaryenIfSetIfTrue(expr: BinaryenExpressionRef, ifTrueExpr: BinaryenExpressionRef)
fun BinaryenInvalidId(): BinaryenExpressionId
fun BinaryenLaneselectI16x8(): BinaryenOp
fun BinaryenLaneselectI32x4(): BinaryenOp
fun BinaryenLaneselectI64x2(): BinaryenOp
fun BinaryenLaneselectI8x16(): BinaryenOp
fun BinaryenLeFloat32(): BinaryenOp
fun BinaryenLeFloat64(): BinaryenOp
fun BinaryenLeSInt32(): BinaryenOp
fun BinaryenLeSInt64(): BinaryenOp
fun BinaryenLeSVecI16x8(): BinaryenOp
fun BinaryenLeSVecI32x4(): BinaryenOp
fun BinaryenLeSVecI64x2(): BinaryenOp
fun BinaryenLeSVecI8x16(): BinaryenOp
fun BinaryenLeUInt32(): BinaryenOp
fun BinaryenLeUInt64(): BinaryenOp
fun BinaryenLeUVecI16x8(): BinaryenOp
fun BinaryenLeUVecI32x4(): BinaryenOp
fun BinaryenLeUVecI8x16(): BinaryenOp
fun BinaryenLeVecF32x4(): BinaryenOp
fun BinaryenLeVecF64x2(): BinaryenOp
fun BinaryenLiteralFloat32(x: Float): BinaryenLiteral
fun BinaryenLiteralFloat32Bits(x: Int): BinaryenLiteral
fun BinaryenLiteralFloat64(x: Double): BinaryenLiteral
fun BinaryenLiteralFloat64Bits(x: Long): BinaryenLiteral
fun BinaryenLiteralInt32(x: Int): BinaryenLiteral
fun BinaryenLiteralInt64(x: Long): BinaryenLiteral
fun BinaryenLiteralVec128(x: Byte): BinaryenLiteral
fun BinaryenLoad(module: BinaryenModuleRef, bytes: Int, signed_: Boolean, offset: Int, align: Int, type: BinaryenType, ptr: BinaryenExpressionRef, memoryName: String): BinaryenExpressionRef
fun BinaryenLoad16LaneVec128(): BinaryenOp
fun BinaryenLoad16SplatVec128(): BinaryenOp
fun BinaryenLoad16x4SVec128(): BinaryenOp
fun BinaryenLoad16x4UVec128(): BinaryenOp
fun BinaryenLoad32LaneVec128(): BinaryenOp
fun BinaryenLoad32SplatVec128(): BinaryenOp
fun BinaryenLoad32ZeroVec128(): BinaryenOp
fun BinaryenLoad32x2SVec128(): BinaryenOp
fun BinaryenLoad32x2UVec128(): BinaryenOp
fun BinaryenLoad64LaneVec128(): BinaryenOp
fun BinaryenLoad64SplatVec128(): BinaryenOp
fun BinaryenLoad64ZeroVec128(): BinaryenOp
fun BinaryenLoad8LaneVec128(): BinaryenOp
fun BinaryenLoad8SplatVec128(): BinaryenOp
fun BinaryenLoad8x8SVec128(): BinaryenOp
fun BinaryenLoad8x8UVec128(): BinaryenOp
fun BinaryenLoadGetAlign(expr: BinaryenExpressionRef): Int
fun BinaryenLoadGetBytes(expr: BinaryenExpressionRef): Int
fun BinaryenLoadGetOffset(expr: BinaryenExpressionRef): Int
fun BinaryenLoadGetPtr(expr: BinaryenExpressionRef): BinaryenExpressionRef
fun BinaryenLoadId(): BinaryenExpressionId
fun BinaryenLoadIsAtomic(expr: BinaryenExpressionRef): Boolean
fun BinaryenLoadIsSigned(expr: BinaryenExpressionRef): Boolean
fun BinaryenLoadSetAlign(expr: BinaryenExpressionRef, align: Int)
fun BinaryenLoadSetAtomic(expr: BinaryenExpressionRef, isAtomic: Boolean)
fun BinaryenLoadSetBytes(expr: BinaryenExpressionRef, bytes: Int)
fun BinaryenLoadSetOffset(expr: BinaryenExpressionRef, offset: Int)
fun BinaryenLoadSetPtr(expr: BinaryenExpressionRef, ptrExpr: BinaryenExpressionRef)
fun BinaryenLoadSetSigned(expr: BinaryenExpressionRef, isSigned: Boolean)
fun BinaryenLocalGet(module: BinaryenModuleRef, index: Int, type: BinaryenType): BinaryenExpressionRef
fun BinaryenLocalGetGetIndex(expr: BinaryenExpressionRef): Int
fun BinaryenLocalGetId(): BinaryenExpressionId
fun BinaryenLocalGetSetIndex(expr: BinaryenExpressionRef, index: Int)
fun BinaryenLocalSet(module: BinaryenModuleRef, index: Int, value: BinaryenExpressionRef): BinaryenExpressionRef
fun BinaryenLocalSetGetIndex(expr: BinaryenExpressionRef): Int
fun BinaryenLocalSetGetValue(expr: BinaryenExpressionRef): BinaryenExpressionRef
fun BinaryenLocalSetId(): BinaryenExpressionId
fun BinaryenLocalSetIsTee(expr: BinaryenExpressionRef): Boolean
fun BinaryenLocalSetSetIndex(expr: BinaryenExpressionRef, index: Int)
fun BinaryenLocalSetSetValue(expr: BinaryenExpressionRef, valueExpr: BinaryenExpressionRef)
fun BinaryenLocalTee(module: BinaryenModuleRef, index: Int, value: BinaryenExpressionRef, type: BinaryenType): BinaryenExpressionRef
fun BinaryenLoop(module: BinaryenModuleRef, `in`: String, body: BinaryenExpressionRef): BinaryenExpressionRef
fun BinaryenLoopGetBody(expr: BinaryenExpressionRef): BinaryenExpressionRef
fun BinaryenLoopGetName(expr: BinaryenExpressionRef): String
fun BinaryenLoopId(): BinaryenExpressionId
fun BinaryenLoopSetBody(expr: BinaryenExpressionRef, bodyExpr: BinaryenExpressionRef)
fun BinaryenLoopSetName(expr: BinaryenExpressionRef, name: String)
fun BinaryenLtFloat32(): BinaryenOp
fun BinaryenLtFloat64(): BinaryenOp
fun BinaryenLtSInt32(): BinaryenOp
fun BinaryenLtSInt64(): BinaryenOp
fun BinaryenLtSVecI16x8(): BinaryenOp
fun BinaryenLtSVecI32x4(): BinaryenOp
fun BinaryenLtSVecI64x2(): BinaryenOp
fun BinaryenLtSVecI8x16(): BinaryenOp
fun BinaryenLtUInt32(): BinaryenOp
fun BinaryenLtUInt64(): BinaryenOp
fun BinaryenLtUVecI16x8(): BinaryenOp
fun BinaryenLtUVecI32x4(): BinaryenOp
fun BinaryenLtUVecI8x16(): BinaryenOp
fun BinaryenLtVecF32x4(): BinaryenOp
fun BinaryenLtVecF64x2(): BinaryenOp
fun BinaryenMaxFloat32(): BinaryenOp
fun BinaryenMaxFloat64(): BinaryenOp
fun BinaryenMaxSVecI16x8(): BinaryenOp
fun BinaryenMaxSVecI32x4(): BinaryenOp
fun BinaryenMaxSVecI8x16(): BinaryenOp
fun BinaryenMaxUVecI16x8(): BinaryenOp
fun BinaryenMaxUVecI32x4(): BinaryenOp
fun BinaryenMaxUVecI8x16(): BinaryenOp
fun BinaryenMaxVecF32x4(): BinaryenOp
fun BinaryenMaxVecF64x2(): BinaryenOp
fun BinaryenMemoryCopy(module: BinaryenModuleRef, dest: BinaryenExpressionRef, source: BinaryenExpressionRef, size: BinaryenExpressionRef, destMemory: String, sourceMemory: String): BinaryenExpressionRef
fun BinaryenMemoryCopyGetDest(expr: BinaryenExpressionRef): BinaryenExpressionRef
fun BinaryenMemoryCopyGetSize(expr: BinaryenExpressionRef): BinaryenExpressionRef
fun BinaryenMemoryCopyGetSource(expr: BinaryenExpressionRef): BinaryenExpressionRef
fun BinaryenMemoryCopyId(): BinaryenExpressionId
fun BinaryenMemoryCopySetDest(expr: BinaryenExpressionRef, destExpr: BinaryenExpressionRef)
fun BinaryenMemoryCopySetSize(expr: BinaryenExpressionRef, sizeExpr: BinaryenExpressionRef)
fun BinaryenMemoryCopySetSource(expr: BinaryenExpressionRef, sourceExpr: BinaryenExpressionRef)
fun BinaryenMemoryFill(module: BinaryenModuleRef, dest: BinaryenExpressionRef, value: BinaryenExpressionRef, size: BinaryenExpressionRef, memoryName: String): BinaryenExpressionRef
fun BinaryenMemoryFillGetDest(expr: BinaryenExpressionRef): BinaryenExpressionRef
fun BinaryenMemoryFillGetSize(expr: BinaryenExpressionRef): BinaryenExpressionRef
fun BinaryenMemoryFillGetValue(expr: BinaryenExpressionRef): BinaryenExpressionRef
fun BinaryenMemoryFillId(): BinaryenExpressionId
fun BinaryenMemoryFillSetDest(expr: BinaryenExpressionRef, destExpr: BinaryenExpressionRef)
fun BinaryenMemoryFillSetSize(expr: BinaryenExpressionRef, sizeExpr: BinaryenExpressionRef)
fun BinaryenMemoryFillSetValue(expr: BinaryenExpressionRef, valueExpr: BinaryenExpressionRef)
fun BinaryenMemoryGetInitial(module: BinaryenModuleRef, name: String): Int
fun BinaryenMemoryGetMax(module: BinaryenModuleRef, name: String): Int
fun BinaryenMemoryGrow(module: BinaryenModuleRef, delta: BinaryenExpressionRef, memoryName: String, memoryIs64: Boolean): BinaryenExpressionRef
fun BinaryenMemoryGrowGetDelta(expr: BinaryenExpressionRef): BinaryenExpressionRef
fun BinaryenMemoryGrowId(): BinaryenExpressionId
fun BinaryenMemoryGrowSetDelta(expr: BinaryenExpressionRef, deltaExpr: BinaryenExpressionRef)
fun BinaryenMemoryHasMax(module: BinaryenModuleRef, name: String): Boolean
fun BinaryenMemoryImportGetBase(module: BinaryenModuleRef, name: String): String
fun BinaryenMemoryImportGetModule(module: BinaryenModuleRef, name: String): String
fun BinaryenMemoryInit(module: BinaryenModuleRef, segment: String, dest: BinaryenExpressionRef, offset: BinaryenExpressionRef, size: BinaryenExpressionRef, memoryName: String): BinaryenExpressionRef
fun BinaryenMemoryInitGetDest(expr: BinaryenExpressionRef): BinaryenExpressionRef
fun BinaryenMemoryInitGetOffset(expr: BinaryenExpressionRef): BinaryenExpressionRef
fun BinaryenMemoryInitGetSegment(expr: BinaryenExpressionRef): String
fun BinaryenMemoryInitGetSize(expr: BinaryenExpressionRef): BinaryenExpressionRef
fun BinaryenMemoryInitId(): BinaryenExpressionId
fun BinaryenMemoryInitSetDest(expr: BinaryenExpressionRef, destExpr: BinaryenExpressionRef)
fun BinaryenMemoryInitSetOffset(expr: BinaryenExpressionRef, offsetExpr: BinaryenExpressionRef)
fun BinaryenMemoryInitSetSegment(expr: BinaryenExpressionRef, segment: String)
fun BinaryenMemoryInitSetSize(expr: BinaryenExpressionRef, sizeExpr: BinaryenExpressionRef)
fun BinaryenMemoryIs64(module: BinaryenModuleRef, name: String): Boolean
fun BinaryenMemoryIsShared(module: BinaryenModuleRef, name: String): Boolean
fun BinaryenMemorySize(module: BinaryenModuleRef, memoryName: String, memoryIs64: Boolean): BinaryenExpressionRef
fun BinaryenMemorySizeId(): BinaryenExpressionId
fun BinaryenMinFloat32(): BinaryenOp
fun BinaryenMinFloat64(): BinaryenOp
fun BinaryenMinSVecI16x8(): BinaryenOp
fun BinaryenMinSVecI32x4(): BinaryenOp
fun BinaryenMinSVecI8x16(): BinaryenOp
fun BinaryenMinUVecI16x8(): BinaryenOp
fun BinaryenMinUVecI32x4(): BinaryenOp
fun BinaryenMinUVecI8x16(): BinaryenOp
fun BinaryenMinVecF32x4(): BinaryenOp
fun BinaryenMinVecF64x2(): BinaryenOp
fun BinaryenModuleAddDebugInfoFileName(module: BinaryenModuleRef, filename: String): Int
fun BinaryenModuleAllocateAndWrite(module: BinaryenModuleRef, sourceMapUrl: String): BinaryenModuleAllocateAndWriteResult
fun BinaryenModuleAllocateAndWriteStackIR(module: BinaryenModuleRef): String
fun BinaryenModuleAllocateAndWriteText(module: BinaryenModuleRef): String
fun BinaryenModuleAutoDrop(module: BinaryenModuleRef)
fun BinaryenModuleCreate(): BinaryenModuleRef
fun BinaryenModuleDispose(module: BinaryenModuleRef)
fun BinaryenModuleGetDebugInfoFileName(module: BinaryenModuleRef, index: Int): String
fun BinaryenModuleGetFeatures(module: BinaryenModuleRef): BinaryenFeatures
fun BinaryenModuleInterpret(module: BinaryenModuleRef)
fun BinaryenModuleOptimize(module: BinaryenModuleRef)
fun BinaryenModuleParse(text: String): BinaryenModuleRef
fun BinaryenModulePrint(module: BinaryenModuleRef)
fun BinaryenModulePrintAsmjs(module: BinaryenModuleRef)
fun BinaryenModulePrintStackIR(module: BinaryenModuleRef)
fun BinaryenModuleRead(input: String, inputSize: Int): BinaryenModuleRef
fun BinaryenModuleReadWithFeatures(input: String, inputSize: Int, featureSet: BinaryenFeatures): BinaryenModuleRef
fun BinaryenModuleRunPasses(module: BinaryenModuleRef, passes: Array<String>, numPasses: Int)
fun BinaryenModuleSetFeatures(module: BinaryenModuleRef, features: BinaryenFeatures)
fun BinaryenModuleSetFieldName(module: BinaryenModuleRef, heapType: BinaryenHeapType, index: Int, name: String)
fun BinaryenModuleSetTypeName(module: BinaryenModuleRef, heapType: BinaryenHeapType, name: String)
fun BinaryenModuleUpdateMaps(module: BinaryenModuleRef)
fun BinaryenModuleValidate(module: BinaryenModuleRef): Boolean
fun BinaryenModuleWrite(module: BinaryenModuleRef, output: String, outputSize: Int): Int
fun BinaryenModuleWriteStackIR(module: BinaryenModuleRef, output: String, outputSize: Int): Int
fun BinaryenModuleWriteText(module: BinaryenModuleRef, output: String, outputSize: Int): Int
fun BinaryenModuleWriteWithSourceMap(module: BinaryenModuleRef, url: String, output: String, outputSize: Int, sourceMap: String, sourceMapSize: Int): BinaryenBufferSizes
fun BinaryenMulFloat32(): BinaryenOp
fun BinaryenMulFloat64(): BinaryenOp
fun BinaryenMulInt32(): BinaryenOp
fun BinaryenMulInt64(): BinaryenOp
fun BinaryenMulVecF32x4(): BinaryenOp
fun BinaryenMulVecF64x2(): BinaryenOp
fun BinaryenMulVecI16x8(): BinaryenOp
fun BinaryenMulVecI32x4(): BinaryenOp
fun BinaryenMulVecI64x2(): BinaryenOp
fun BinaryenNarrowSVecI16x8ToVecI8x16(): BinaryenOp
fun BinaryenNarrowSVecI32x4ToVecI16x8(): BinaryenOp
fun BinaryenNarrowUVecI16x8ToVecI8x16(): BinaryenOp
fun BinaryenNarrowUVecI32x4ToVecI16x8(): BinaryenOp
fun BinaryenNeFloat32(): BinaryenOp
fun BinaryenNeFloat64(): BinaryenOp
fun BinaryenNeInt32(): BinaryenOp
fun BinaryenNeInt64(): BinaryenOp
fun BinaryenNeVecF32x4(): BinaryenOp
fun BinaryenNeVecF64x2(): BinaryenOp
fun BinaryenNeVecI16x8(): BinaryenOp
fun BinaryenNeVecI32x4(): BinaryenOp
fun BinaryenNeVecI64x2(): BinaryenOp
fun BinaryenNeVecI8x16(): BinaryenOp
fun BinaryenNearestFloat32(): BinaryenOp
fun BinaryenNearestFloat64(): BinaryenOp
fun BinaryenNearestVecF32x4(): BinaryenOp
fun BinaryenNearestVecF64x2(): BinaryenOp
fun BinaryenNegFloat32(): BinaryenOp
fun BinaryenNegFloat64(): BinaryenOp
fun BinaryenNegVecF32x4(): BinaryenOp
fun BinaryenNegVecF64x2(): BinaryenOp
fun BinaryenNegVecI16x8(): BinaryenOp
fun BinaryenNegVecI32x4(): BinaryenOp
fun BinaryenNegVecI64x2(): BinaryenOp
fun BinaryenNegVecI8x16(): BinaryenOp
fun BinaryenNop(module: BinaryenModuleRef): BinaryenExpressionRef
fun BinaryenNopId(): BinaryenExpressionId
fun BinaryenNotVec128(): BinaryenOp
fun BinaryenOrInt32(): BinaryenOp
fun BinaryenOrInt64(): BinaryenOp
fun BinaryenOrVec128(): BinaryenOp
fun BinaryenPMaxVecF32x4(): BinaryenOp
fun BinaryenPMaxVecF64x2(): BinaryenOp
fun BinaryenPMinVecF32x4(): BinaryenOp
fun BinaryenPMinVecF64x2(): BinaryenOp
fun BinaryenPackedTypeInt16(): BinaryenPackedType
fun BinaryenPackedTypeInt8(): BinaryenPackedType
fun BinaryenPackedTypeNotPacked(): BinaryenPackedType
fun BinaryenPop(module: BinaryenModuleRef, type: BinaryenType): BinaryenExpressionRef
fun BinaryenPopId(): BinaryenExpressionId
fun BinaryenPopcntInt32(): BinaryenOp
fun BinaryenPopcntInt64(): BinaryenOp
fun BinaryenPopcntVecI8x16(): BinaryenOp
fun BinaryenPromoteFloat32(): BinaryenOp
fun BinaryenPromoteLowVecF32x4ToVecF64x2(): BinaryenOp
fun BinaryenQ15MulrSatSVecI16x8(): BinaryenOp
fun BinaryenRefAs(module: BinaryenModuleRef, op: BinaryenOp, value: BinaryenExpressionRef): BinaryenExpressionRef
fun BinaryenRefAsAnyConvertExtern(): BinaryenOp
fun BinaryenRefAsExternConvertAny(): BinaryenOp
fun BinaryenRefAsExternExternalize(): BinaryenOp
fun BinaryenRefAsExternInternalize(): BinaryenOp
fun BinaryenRefAsGetOp(expr: BinaryenExpressionRef): BinaryenOp
fun BinaryenRefAsGetValue(expr: BinaryenExpressionRef): BinaryenExpressionRef
fun BinaryenRefAsId(): BinaryenExpressionId
fun BinaryenRefAsNonNull(): BinaryenOp
fun BinaryenRefAsSetOp(expr: BinaryenExpressionRef, op: BinaryenOp)
fun BinaryenRefAsSetValue(expr: BinaryenExpressionRef, valueExpr: BinaryenExpressionRef)
fun BinaryenRefCast(module: BinaryenModuleRef, ref: BinaryenExpressionRef, type: BinaryenType): BinaryenExpressionRef
fun BinaryenRefCastGetRef(expr: BinaryenExpressionRef): BinaryenExpressionRef
fun BinaryenRefCastId(): BinaryenExpressionId
fun BinaryenRefCastSetRef(expr: BinaryenExpressionRef, refExpr: BinaryenExpressionRef)
fun BinaryenRefEq(module: BinaryenModuleRef, left: BinaryenExpressionRef, right: BinaryenExpressionRef): BinaryenExpressionRef
fun BinaryenRefEqGetLeft(expr: BinaryenExpressionRef): BinaryenExpressionRef
fun BinaryenRefEqGetRight(expr: BinaryenExpressionRef): BinaryenExpressionRef
fun BinaryenRefEqId(): BinaryenExpressionId
fun BinaryenRefEqSetLeft(expr: BinaryenExpressionRef, left: BinaryenExpressionRef)
fun BinaryenRefEqSetRight(expr: BinaryenExpressionRef, right: BinaryenExpressionRef)
fun BinaryenRefFunc(module: BinaryenModuleRef, func: String, type: BinaryenType): BinaryenExpressionRef
fun BinaryenRefFuncGetFunc(expr: BinaryenExpressionRef): String
fun BinaryenRefFuncId(): BinaryenExpressionId
fun BinaryenRefFuncSetFunc(expr: BinaryenExpressionRef, funcName: String)
fun BinaryenRefI31(module: BinaryenModuleRef, value: BinaryenExpressionRef): BinaryenExpressionRef
fun BinaryenRefI31GetValue(expr: BinaryenExpressionRef): BinaryenExpressionRef
fun BinaryenRefI31Id(): BinaryenExpressionId
fun BinaryenRefI31SetValue(expr: BinaryenExpressionRef, valueExpr: BinaryenExpressionRef)
fun BinaryenRefIsNull(module: BinaryenModuleRef, value: BinaryenExpressionRef): BinaryenExpressionRef
fun BinaryenRefIsNullGetValue(expr: BinaryenExpressionRef): BinaryenExpressionRef
fun BinaryenRefIsNullId(): BinaryenExpressionId
fun BinaryenRefIsNullSetValue(expr: BinaryenExpressionRef, valueExpr: BinaryenExpressionRef)
fun BinaryenRefNull(module: BinaryenModuleRef, type: BinaryenType): BinaryenExpressionRef
fun BinaryenRefNullId(): BinaryenExpressionId
fun BinaryenRefTest(module: BinaryenModuleRef, ref: BinaryenExpressionRef, castType: BinaryenType): BinaryenExpressionRef
fun BinaryenRefTestGetCastType(expr: BinaryenExpressionRef): BinaryenType
fun BinaryenRefTestGetRef(expr: BinaryenExpressionRef): BinaryenExpressionRef
fun BinaryenRefTestId(): BinaryenExpressionId
fun BinaryenRefTestSetCastType(expr: BinaryenExpressionRef, intendedType: BinaryenType)
fun BinaryenRefTestSetRef(expr: BinaryenExpressionRef, refExpr: BinaryenExpressionRef)
fun BinaryenReinterpretFloat32(): BinaryenOp
fun BinaryenReinterpretFloat64(): BinaryenOp
fun BinaryenReinterpretInt32(): BinaryenOp
fun BinaryenReinterpretInt64(): BinaryenOp
fun BinaryenRelaxedFmaVecF32x4(): BinaryenOp
fun BinaryenRelaxedFmaVecF64x2(): BinaryenOp
fun BinaryenRelaxedFmsVecF32x4(): BinaryenOp
fun BinaryenRelaxedFmsVecF64x2(): BinaryenOp
fun BinaryenRelaxedMaxVecF32x4(): BinaryenOp
fun BinaryenRelaxedMaxVecF64x2(): BinaryenOp
fun BinaryenRelaxedMinVecF32x4(): BinaryenOp
fun BinaryenRelaxedMinVecF64x2(): BinaryenOp
fun BinaryenRelaxedQ15MulrSVecI16x8(): BinaryenOp
fun BinaryenRelaxedSwizzleVecI8x16(): BinaryenOp
fun BinaryenRelaxedTruncSVecF32x4ToVecI32x4(): BinaryenOp
fun BinaryenRelaxedTruncUVecF32x4ToVecI32x4(): BinaryenOp
fun BinaryenRelaxedTruncZeroSVecF64x2ToVecI32x4(): BinaryenOp
fun BinaryenRelaxedTruncZeroUVecF64x2ToVecI32x4(): BinaryenOp
fun BinaryenRemSInt32(): BinaryenOp
fun BinaryenRemSInt64(): BinaryenOp
fun BinaryenRemUInt32(): BinaryenOp
fun BinaryenRemUInt64(): BinaryenOp
fun BinaryenRemoveElementSegment(module: BinaryenModuleRef, name: String)
fun BinaryenRemoveExport(module: BinaryenModuleRef, externalName: String)
fun BinaryenRemoveFunction(module: BinaryenModuleRef, name: String)
fun BinaryenRemoveGlobal(module: BinaryenModuleRef, name: String)
fun BinaryenRemoveTable(module: BinaryenModuleRef, table: String)
fun BinaryenRemoveTag(module: BinaryenModuleRef, name: String)
fun BinaryenReplaceLaneVecF32x4(): BinaryenOp
fun BinaryenReplaceLaneVecF64x2(): BinaryenOp
fun BinaryenReplaceLaneVecI16x8(): BinaryenOp
fun BinaryenReplaceLaneVecI32x4(): BinaryenOp
fun BinaryenReplaceLaneVecI64x2(): BinaryenOp
fun BinaryenReplaceLaneVecI8x16(): BinaryenOp
fun BinaryenResumeId(): BinaryenExpressionId
fun BinaryenRethrow(module: BinaryenModuleRef, target: String): BinaryenExpressionRef
fun BinaryenRethrowGetTarget(expr: BinaryenExpressionRef): String
fun BinaryenRethrowId(): BinaryenExpressionId
fun BinaryenRethrowSetTarget(expr: BinaryenExpressionRef, target: String)
fun BinaryenReturn(module: BinaryenModuleRef, value: BinaryenExpressionRef): BinaryenExpressionRef
fun BinaryenReturnCall(module: BinaryenModuleRef, target: String, operands: Array<BinaryenExpressionRef>?, numOperands: Int, returnType: BinaryenType): BinaryenExpressionRef
fun BinaryenReturnCallIndirect(module: BinaryenModuleRef, table: String, target: BinaryenExpressionRef, operands: Array<BinaryenExpressionRef>?, numOperands: Int, params: BinaryenType, results: BinaryenType): BinaryenExpressionRef
fun BinaryenReturnGetValue(expr: BinaryenExpressionRef): BinaryenExpressionRef
fun BinaryenReturnId(): BinaryenExpressionId
fun BinaryenReturnSetValue(expr: BinaryenExpressionRef, valueExpr: BinaryenExpressionRef)
fun BinaryenRotLInt32(): BinaryenOp
fun BinaryenRotLInt64(): BinaryenOp
fun BinaryenRotRInt32(): BinaryenOp
fun BinaryenRotRInt64(): BinaryenOp
fun BinaryenSIMDExtract(module: BinaryenModuleRef, op: BinaryenOp, vec: BinaryenExpressionRef, index: Byte): BinaryenExpressionRef
fun BinaryenSIMDExtractGetIndex(expr: BinaryenExpressionRef): Byte
fun BinaryenSIMDExtractGetOp(expr: BinaryenExpressionRef): BinaryenOp
fun BinaryenSIMDExtractGetVec(expr: BinaryenExpressionRef): BinaryenExpressionRef
fun BinaryenSIMDExtractId(): BinaryenExpressionId
fun BinaryenSIMDExtractSetIndex(expr: BinaryenExpressionRef, index: Byte)
fun BinaryenSIMDExtractSetOp(expr: BinaryenExpressionRef, op: BinaryenOp)
fun BinaryenSIMDExtractSetVec(expr: BinaryenExpressionRef, vecExpr: BinaryenExpressionRef)
fun BinaryenSIMDLoad(module: BinaryenModuleRef, op: BinaryenOp, offset: Int, align: Int, ptr: BinaryenExpressionRef, name: String): BinaryenExpressionRef
fun BinaryenSIMDLoadGetAlign(expr: BinaryenExpressionRef): Int
fun BinaryenSIMDLoadGetOffset(expr: BinaryenExpressionRef): Int
fun BinaryenSIMDLoadGetOp(expr: BinaryenExpressionRef): BinaryenOp
fun BinaryenSIMDLoadGetPtr(expr: BinaryenExpressionRef): BinaryenExpressionRef
fun BinaryenSIMDLoadId(): BinaryenExpressionId
fun BinaryenSIMDLoadSetAlign(expr: BinaryenExpressionRef, align: Int)
fun BinaryenSIMDLoadSetOffset(expr: BinaryenExpressionRef, offset: Int)
fun BinaryenSIMDLoadSetOp(expr: BinaryenExpressionRef, op: BinaryenOp)
fun BinaryenSIMDLoadSetPtr(expr: BinaryenExpressionRef, ptrExpr: BinaryenExpressionRef)
fun BinaryenSIMDLoadStoreLane(module: BinaryenModuleRef, op: BinaryenOp, offset: Int, align: Int, index: Byte, ptr: BinaryenExpressionRef, vec: BinaryenExpressionRef, memoryName: String): BinaryenExpressionRef
fun BinaryenSIMDLoadStoreLaneGetAlign(expr: BinaryenExpressionRef): Int
fun BinaryenSIMDLoadStoreLaneGetIndex(expr: BinaryenExpressionRef): Byte
fun BinaryenSIMDLoadStoreLaneGetOffset(expr: BinaryenExpressionRef): Int
fun BinaryenSIMDLoadStoreLaneGetOp(expr: BinaryenExpressionRef): BinaryenOp
fun BinaryenSIMDLoadStoreLaneGetPtr(expr: BinaryenExpressionRef): BinaryenExpressionRef
fun BinaryenSIMDLoadStoreLaneGetVec(expr: BinaryenExpressionRef): BinaryenExpressionRef
fun BinaryenSIMDLoadStoreLaneId(): BinaryenExpressionId
fun BinaryenSIMDLoadStoreLaneIsStore(expr: BinaryenExpressionRef): Boolean
fun BinaryenSIMDLoadStoreLaneSetAlign(expr: BinaryenExpressionRef, align: Int)
fun BinaryenSIMDLoadStoreLaneSetIndex(expr: BinaryenExpressionRef, index: Byte)
fun BinaryenSIMDLoadStoreLaneSetOffset(expr: BinaryenExpressionRef, offset: Int)
fun BinaryenSIMDLoadStoreLaneSetOp(expr: BinaryenExpressionRef, op: BinaryenOp)
fun BinaryenSIMDLoadStoreLaneSetPtr(expr: BinaryenExpressionRef, ptrExpr: BinaryenExpressionRef)
fun BinaryenSIMDLoadStoreLaneSetVec(expr: BinaryenExpressionRef, vecExpr: BinaryenExpressionRef)
fun BinaryenSIMDReplace(module: BinaryenModuleRef, op: BinaryenOp, vec: BinaryenExpressionRef, index: Byte, value: BinaryenExpressionRef): BinaryenExpressionRef
fun BinaryenSIMDReplaceGetIndex(expr: BinaryenExpressionRef): Byte
fun BinaryenSIMDReplaceGetOp(expr: BinaryenExpressionRef): BinaryenOp
fun BinaryenSIMDReplaceGetValue(expr: BinaryenExpressionRef): BinaryenExpressionRef
fun BinaryenSIMDReplaceGetVec(expr: BinaryenExpressionRef): BinaryenExpressionRef
fun BinaryenSIMDReplaceId(): BinaryenExpressionId
fun BinaryenSIMDReplaceSetIndex(expr: BinaryenExpressionRef, index: Byte)
fun BinaryenSIMDReplaceSetOp(expr: BinaryenExpressionRef, op: BinaryenOp)
fun BinaryenSIMDReplaceSetValue(expr: BinaryenExpressionRef, valueExpr: BinaryenExpressionRef)
fun BinaryenSIMDReplaceSetVec(expr: BinaryenExpressionRef, vecExpr: BinaryenExpressionRef)
fun BinaryenSIMDShift(module: BinaryenModuleRef, op: BinaryenOp, vec: BinaryenExpressionRef, shift: BinaryenExpressionRef): BinaryenExpressionRef
fun BinaryenSIMDShiftGetOp(expr: BinaryenExpressionRef): BinaryenOp
fun BinaryenSIMDShiftGetShift(expr: BinaryenExpressionRef): BinaryenExpressionRef
fun BinaryenSIMDShiftGetVec(expr: BinaryenExpressionRef): BinaryenExpressionRef
fun BinaryenSIMDShiftId(): BinaryenExpressionId
fun BinaryenSIMDShiftSetOp(expr: BinaryenExpressionRef, op: BinaryenOp)
fun BinaryenSIMDShiftSetShift(expr: BinaryenExpressionRef, shiftExpr: BinaryenExpressionRef)
fun BinaryenSIMDShiftSetVec(expr: BinaryenExpressionRef, vecExpr: BinaryenExpressionRef)
fun BinaryenSIMDShuffle(module: BinaryenModuleRef, left: BinaryenExpressionRef, right: BinaryenExpressionRef, mask: Byte): BinaryenExpressionRef
fun BinaryenSIMDShuffleGetLeft(expr: BinaryenExpressionRef): BinaryenExpressionRef
fun BinaryenSIMDShuffleGetMask(expr: BinaryenExpressionRef, mask: ByteArray?)
fun BinaryenSIMDShuffleGetRight(expr: BinaryenExpressionRef): BinaryenExpressionRef
fun BinaryenSIMDShuffleId(): BinaryenExpressionId
fun BinaryenSIMDShuffleSetLeft(expr: BinaryenExpressionRef, leftExpr: BinaryenExpressionRef)
fun BinaryenSIMDShuffleSetMask(expr: BinaryenExpressionRef, mask: Byte)
fun BinaryenSIMDShuffleSetRight(expr: BinaryenExpressionRef, rightExpr: BinaryenExpressionRef)
fun BinaryenSIMDTernary(module: BinaryenModuleRef, op: BinaryenOp, a: BinaryenExpressionRef, b: BinaryenExpressionRef, c: BinaryenExpressionRef): BinaryenExpressionRef
fun BinaryenSIMDTernaryGetA(expr: BinaryenExpressionRef): BinaryenExpressionRef
fun BinaryenSIMDTernaryGetB(expr: BinaryenExpressionRef): BinaryenExpressionRef
fun BinaryenSIMDTernaryGetC(expr: BinaryenExpressionRef): BinaryenExpressionRef
fun BinaryenSIMDTernaryGetOp(expr: BinaryenExpressionRef): BinaryenOp
fun BinaryenSIMDTernaryId(): BinaryenExpressionId
fun BinaryenSIMDTernarySetA(expr: BinaryenExpressionRef, aExpr: BinaryenExpressionRef)
fun BinaryenSIMDTernarySetB(expr: BinaryenExpressionRef, bExpr: BinaryenExpressionRef)
fun BinaryenSIMDTernarySetC(expr: BinaryenExpressionRef, cExpr: BinaryenExpressionRef)
fun BinaryenSIMDTernarySetOp(expr: BinaryenExpressionRef, op: BinaryenOp)
fun BinaryenSelect(module: BinaryenModuleRef, condition: BinaryenExpressionRef, ifTrue: BinaryenExpressionRef, ifFalse: BinaryenExpressionRef, type: BinaryenType): BinaryenExpressionRef
fun BinaryenSelectGetCondition(expr: BinaryenExpressionRef): BinaryenExpressionRef
fun BinaryenSelectGetIfFalse(expr: BinaryenExpressionRef): BinaryenExpressionRef
fun BinaryenSelectGetIfTrue(expr: BinaryenExpressionRef): BinaryenExpressionRef
fun BinaryenSelectId(): BinaryenExpressionId
fun BinaryenSelectSetCondition(expr: BinaryenExpressionRef, condExpr: BinaryenExpressionRef)
fun BinaryenSelectSetIfFalse(expr: BinaryenExpressionRef, ifFalseExpr: BinaryenExpressionRef)
fun BinaryenSelectSetIfTrue(expr: BinaryenExpressionRef, ifTrueExpr: BinaryenExpressionRef)
fun BinaryenSetAllowInliningFunctionsWithLoops(enabled: Boolean)
fun BinaryenSetAlwaysInlineMaxSize(size: Int)
fun BinaryenSetColorsEnabled(enabled: Boolean)
fun BinaryenSetDebugInfo(on: Boolean)
fun BinaryenSetFastMath(value: Boolean)
fun BinaryenSetFlexibleInlineMaxSize(size: Int)
fun BinaryenSetLowMemoryUnused(on: Boolean)
fun BinaryenSetMemory(module: BinaryenModuleRef, initial: Int, maximum: Int, exportName: String, segmentNames: Array<String>, segmentDatas: Array<String>, segmentPassives: Array<Boolean>?, segmentOffsets: Array<BinaryenExpressionRef>?, segmentSizes: LongArray?, numSegments: Int, shared: Boolean, memory64: Boolean, name: String)
fun BinaryenSetOneCallerInlineMaxSize(size: Int)
fun BinaryenSetOptimizeLevel(level: Int)
fun BinaryenSetPassArgument(name: String, value: String)
fun BinaryenSetShrinkLevel(level: Int)
fun BinaryenSetStart(module: BinaryenModuleRef, start: BinaryenFunctionRef)
fun BinaryenSetZeroFilledMemory(on: Boolean)
fun BinaryenShlInt32(): BinaryenOp
fun BinaryenShlInt64(): BinaryenOp
fun BinaryenShlVecI16x8(): BinaryenOp
fun BinaryenShlVecI32x4(): BinaryenOp
fun BinaryenShlVecI64x2(): BinaryenOp
fun BinaryenShlVecI8x16(): BinaryenOp
fun BinaryenShrSInt32(): BinaryenOp
fun BinaryenShrSInt64(): BinaryenOp
fun BinaryenShrSVecI16x8(): BinaryenOp
fun BinaryenShrSVecI32x4(): BinaryenOp
fun BinaryenShrSVecI64x2(): BinaryenOp
fun BinaryenShrSVecI8x16(): BinaryenOp
fun BinaryenShrUInt32(): BinaryenOp
fun BinaryenShrUInt64(): BinaryenOp
fun BinaryenShrUVecI16x8(): BinaryenOp
fun BinaryenShrUVecI32x4(): BinaryenOp
fun BinaryenShrUVecI64x2(): BinaryenOp
fun BinaryenShrUVecI8x16(): BinaryenOp
fun BinaryenSideEffectAny(): BinaryenSideEffects
fun BinaryenSideEffectBranches(): BinaryenSideEffects
fun BinaryenSideEffectCalls(): BinaryenSideEffects
fun BinaryenSideEffectDanglingPop(): BinaryenSideEffects
fun BinaryenSideEffectImplicitTrap(): BinaryenSideEffects
fun BinaryenSideEffectIsAtomic(): BinaryenSideEffects
fun BinaryenSideEffectNone(): BinaryenSideEffects
fun BinaryenSideEffectReadsGlobal(): BinaryenSideEffects
fun BinaryenSideEffectReadsLocal(): BinaryenSideEffects
fun BinaryenSideEffectReadsMemory(): BinaryenSideEffects
fun BinaryenSideEffectReadsTable(): BinaryenSideEffects
fun BinaryenSideEffectThrows(): BinaryenSideEffects
fun BinaryenSideEffectTrapsNeverHappen(): BinaryenSideEffects
fun BinaryenSideEffectWritesGlobal(): BinaryenSideEffects
fun BinaryenSideEffectWritesLocal(): BinaryenSideEffects
fun BinaryenSideEffectWritesMemory(): BinaryenSideEffects
fun BinaryenSideEffectWritesTable(): BinaryenSideEffects
fun BinaryenSignatureTypeGetParams(heapType: BinaryenHeapType): BinaryenType
fun BinaryenSignatureTypeGetResults(heapType: BinaryenHeapType): BinaryenType
fun BinaryenSplatVecF32x4(): BinaryenOp
fun BinaryenSplatVecF64x2(): BinaryenOp
fun BinaryenSplatVecI16x8(): BinaryenOp
fun BinaryenSplatVecI32x4(): BinaryenOp
fun BinaryenSplatVecI64x2(): BinaryenOp
fun BinaryenSplatVecI8x16(): BinaryenOp
fun BinaryenSqrtFloat32(): BinaryenOp
fun BinaryenSqrtFloat64(): BinaryenOp
fun BinaryenSqrtVecF32x4(): BinaryenOp
fun BinaryenSqrtVecF64x2(): BinaryenOp
fun BinaryenStore(module: BinaryenModuleRef, bytes: Int, offset: Int, align: Int, ptr: BinaryenExpressionRef, value: BinaryenExpressionRef, type: BinaryenType, memoryName: String): BinaryenExpressionRef
fun BinaryenStore16LaneVec128(): BinaryenOp
fun BinaryenStore32LaneVec128(): BinaryenOp
fun BinaryenStore64LaneVec128(): BinaryenOp
fun BinaryenStore8LaneVec128(): BinaryenOp
fun BinaryenStoreGetAlign(expr: BinaryenExpressionRef): Int
fun BinaryenStoreGetBytes(expr: BinaryenExpressionRef): Int
fun BinaryenStoreGetOffset(expr: BinaryenExpressionRef): Int
fun BinaryenStoreGetPtr(expr: BinaryenExpressionRef): BinaryenExpressionRef
fun BinaryenStoreGetValue(expr: BinaryenExpressionRef): BinaryenExpressionRef
fun BinaryenStoreGetValueType(expr: BinaryenExpressionRef): BinaryenType
fun BinaryenStoreId(): BinaryenExpressionId
fun BinaryenStoreIsAtomic(expr: BinaryenExpressionRef): Boolean
fun BinaryenStoreSetAlign(expr: BinaryenExpressionRef, align: Int)
fun BinaryenStoreSetAtomic(expr: BinaryenExpressionRef, isAtomic: Boolean)
fun BinaryenStoreSetBytes(expr: BinaryenExpressionRef, bytes: Int)
fun BinaryenStoreSetOffset(expr: BinaryenExpressionRef, offset: Int)
fun BinaryenStoreSetPtr(expr: BinaryenExpressionRef, ptrExpr: BinaryenExpressionRef)
fun BinaryenStoreSetValue(expr: BinaryenExpressionRef, valueExpr: BinaryenExpressionRef)
fun BinaryenStoreSetValueType(expr: BinaryenExpressionRef, valueType: BinaryenType)
fun BinaryenStringConcat(module: BinaryenModuleRef, left: BinaryenExpressionRef, right: BinaryenExpressionRef): BinaryenExpressionRef
fun BinaryenStringConcatGetLeft(expr: BinaryenExpressionRef): BinaryenExpressionRef
fun BinaryenStringConcatGetRight(expr: BinaryenExpressionRef): BinaryenExpressionRef
fun BinaryenStringConcatId(): BinaryenExpressionId
fun BinaryenStringConcatSetLeft(expr: BinaryenExpressionRef, leftExpr: BinaryenExpressionRef)
fun BinaryenStringConcatSetRight(expr: BinaryenExpressionRef, rightExpr: BinaryenExpressionRef)
fun BinaryenStringConst(module: BinaryenModuleRef, name: String): BinaryenExpressionRef
fun BinaryenStringConstGetString(expr: BinaryenExpressionRef): String
fun BinaryenStringConstId(): BinaryenExpressionId
fun BinaryenStringConstSetString(expr: BinaryenExpressionRef, stringStr: String)
fun BinaryenStringEncode(module: BinaryenModuleRef, op: BinaryenOp, ref: BinaryenExpressionRef, ptr: BinaryenExpressionRef, start: BinaryenExpressionRef): BinaryenExpressionRef
fun BinaryenStringEncodeGetArray(expr: BinaryenExpressionRef): BinaryenExpressionRef
fun BinaryenStringEncodeGetOp(expr: BinaryenExpressionRef): BinaryenOp
fun BinaryenStringEncodeGetStart(expr: BinaryenExpressionRef): BinaryenExpressionRef
fun BinaryenStringEncodeGetStr(expr: BinaryenExpressionRef): BinaryenExpressionRef
fun BinaryenStringEncodeId(): BinaryenExpressionId
fun BinaryenStringEncodeLossyUTF8Array(): BinaryenOp
fun BinaryenStringEncodeSetArray(expr: BinaryenExpressionRef, ptrExpr: BinaryenExpressionRef)
fun BinaryenStringEncodeSetOp(expr: BinaryenExpressionRef, op: BinaryenOp)
fun BinaryenStringEncodeSetStart(expr: BinaryenExpressionRef, startExpr: BinaryenExpressionRef)
fun BinaryenStringEncodeSetStr(expr: BinaryenExpressionRef, refExpr: BinaryenExpressionRef)
fun BinaryenStringEncodeWTF16Array(): BinaryenOp
fun BinaryenStringEq(module: BinaryenModuleRef, op: BinaryenOp, left: BinaryenExpressionRef, right: BinaryenExpressionRef): BinaryenExpressionRef
fun BinaryenStringEqCompare(): BinaryenOp
fun BinaryenStringEqEqual(): BinaryenOp
fun BinaryenStringEqGetLeft(expr: BinaryenExpressionRef): BinaryenExpressionRef
fun BinaryenStringEqGetOp(expr: BinaryenExpressionRef): BinaryenOp
fun BinaryenStringEqGetRight(expr: BinaryenExpressionRef): BinaryenExpressionRef
fun BinaryenStringEqId(): BinaryenExpressionId
fun BinaryenStringEqSetLeft(expr: BinaryenExpressionRef, leftExpr: BinaryenExpressionRef)
fun BinaryenStringEqSetOp(expr: BinaryenExpressionRef, op: BinaryenOp)
fun BinaryenStringEqSetRight(expr: BinaryenExpressionRef, rightExpr: BinaryenExpressionRef)
fun BinaryenStringMeasure(module: BinaryenModuleRef, op: BinaryenOp, ref: BinaryenExpressionRef): BinaryenExpressionRef
fun BinaryenStringMeasureGetOp(expr: BinaryenExpressionRef): BinaryenOp
fun BinaryenStringMeasureGetRef(expr: BinaryenExpressionRef): BinaryenExpressionRef
fun BinaryenStringMeasureId(): BinaryenExpressionId
fun BinaryenStringMeasureSetOp(expr: BinaryenExpressionRef, op: BinaryenOp)
fun BinaryenStringMeasureSetRef(expr: BinaryenExpressionRef, refExpr: BinaryenExpressionRef)
fun BinaryenStringMeasureUTF8(): BinaryenOp
fun BinaryenStringMeasureWTF16(): BinaryenOp
fun BinaryenStringNew(module: BinaryenModuleRef, op: BinaryenOp, ref: BinaryenExpressionRef, start: BinaryenExpressionRef, end: BinaryenExpressionRef): BinaryenExpressionRef
fun BinaryenStringNewFromCodePoint(): BinaryenOp
fun BinaryenStringNewGetEnd(expr: BinaryenExpressionRef): BinaryenExpressionRef
fun BinaryenStringNewGetOp(expr: BinaryenExpressionRef): BinaryenOp
fun BinaryenStringNewGetRef(expr: BinaryenExpressionRef): BinaryenExpressionRef
fun BinaryenStringNewGetStart(expr: BinaryenExpressionRef): BinaryenExpressionRef
fun BinaryenStringNewId(): BinaryenExpressionId
fun BinaryenStringNewLossyUTF8Array(): BinaryenOp
fun BinaryenStringNewSetEnd(expr: BinaryenExpressionRef, endExpr: BinaryenExpressionRef)
fun BinaryenStringNewSetOp(expr: BinaryenExpressionRef, op: BinaryenOp)
fun BinaryenStringNewSetRef(expr: BinaryenExpressionRef, ptrExpr: BinaryenExpressionRef)
fun BinaryenStringNewSetStart(expr: BinaryenExpressionRef, startExpr: BinaryenExpressionRef)
fun BinaryenStringNewWTF16Array(): BinaryenOp
fun BinaryenStringSliceWTF(module: BinaryenModuleRef, ref: BinaryenExpressionRef, start: BinaryenExpressionRef, end: BinaryenExpressionRef): BinaryenExpressionRef
fun BinaryenStringSliceWTFGetEnd(expr: BinaryenExpressionRef): BinaryenExpressionRef
fun BinaryenStringSliceWTFGetRef(expr: BinaryenExpressionRef): BinaryenExpressionRef
fun BinaryenStringSliceWTFGetStart(expr: BinaryenExpressionRef): BinaryenExpressionRef
fun BinaryenStringSliceWTFId(): BinaryenExpressionId
fun BinaryenStringSliceWTFSetEnd(expr: BinaryenExpressionRef, endExpr: BinaryenExpressionRef)
fun BinaryenStringSliceWTFSetRef(expr: BinaryenExpressionRef, refExpr: BinaryenExpressionRef)
fun BinaryenStringSliceWTFSetStart(expr: BinaryenExpressionRef, startExpr: BinaryenExpressionRef)
fun BinaryenStringWTF16Get(module: BinaryenModuleRef, ref: BinaryenExpressionRef, pos: BinaryenExpressionRef): BinaryenExpressionRef
fun BinaryenStringWTF16GetGetPos(expr: BinaryenExpressionRef): BinaryenExpressionRef
fun BinaryenStringWTF16GetGetRef(expr: BinaryenExpressionRef): BinaryenExpressionRef
fun BinaryenStringWTF16GetId(): BinaryenExpressionId
fun BinaryenStringWTF16GetSetPos(expr: BinaryenExpressionRef, posExpr: BinaryenExpressionRef)
fun BinaryenStringWTF16GetSetRef(expr: BinaryenExpressionRef, refExpr: BinaryenExpressionRef)
fun BinaryenStructGet(module: BinaryenModuleRef, index: Int, ref: BinaryenExpressionRef, type: BinaryenType, signed_: Boolean): BinaryenExpressionRef
fun BinaryenStructGetGetIndex(expr: BinaryenExpressionRef): Int
fun BinaryenStructGetGetRef(expr: BinaryenExpressionRef): BinaryenExpressionRef
fun BinaryenStructGetId(): BinaryenExpressionId
fun BinaryenStructGetIsSigned(expr: BinaryenExpressionRef): Boolean
fun BinaryenStructGetSetIndex(expr: BinaryenExpressionRef, index: Int)
fun BinaryenStructGetSetRef(expr: BinaryenExpressionRef, refExpr: BinaryenExpressionRef)
fun BinaryenStructGetSetSigned(expr: BinaryenExpressionRef, signed_: Boolean)
fun BinaryenStructNew(module: BinaryenModuleRef, operands: Array<BinaryenExpressionRef>?, numOperands: Int, type: BinaryenHeapType): BinaryenExpressionRef
fun BinaryenStructNewAppendOperand(expr: BinaryenExpressionRef, operandExpr: BinaryenExpressionRef): Int
fun BinaryenStructNewGetNumOperands(expr: BinaryenExpressionRef): Int
fun BinaryenStructNewGetOperandAt(expr: BinaryenExpressionRef, index: Int): BinaryenExpressionRef
fun BinaryenStructNewId(): BinaryenExpressionId
fun BinaryenStructNewInsertOperandAt(expr: BinaryenExpressionRef, index: Int, operandExpr: BinaryenExpressionRef)
fun BinaryenStructNewRemoveOperandAt(expr: BinaryenExpressionRef, index: Int): BinaryenExpressionRef
fun BinaryenStructNewSetOperandAt(expr: BinaryenExpressionRef, index: Int, operandExpr: BinaryenExpressionRef)
fun BinaryenStructSet(module: BinaryenModuleRef, index: Int, ref: BinaryenExpressionRef, value: BinaryenExpressionRef): BinaryenExpressionRef
fun BinaryenStructSetGetIndex(expr: BinaryenExpressionRef): Int
fun BinaryenStructSetGetRef(expr: BinaryenExpressionRef): BinaryenExpressionRef
fun BinaryenStructSetGetValue(expr: BinaryenExpressionRef): BinaryenExpressionRef
fun BinaryenStructSetId(): BinaryenExpressionId
fun BinaryenStructSetSetIndex(expr: BinaryenExpressionRef, index: Int)
fun BinaryenStructSetSetRef(expr: BinaryenExpressionRef, refExpr: BinaryenExpressionRef)
fun BinaryenStructSetSetValue(expr: BinaryenExpressionRef, valueExpr: BinaryenExpressionRef)
fun BinaryenStructTypeGetFieldPackedType(heapType: BinaryenHeapType, index: Int): BinaryenPackedType
fun BinaryenStructTypeGetFieldType(heapType: BinaryenHeapType, index: Int): BinaryenType
fun BinaryenStructTypeGetNumFields(heapType: BinaryenHeapType): Int
fun BinaryenStructTypeIsFieldMutable(heapType: BinaryenHeapType, index: Int): Boolean
fun BinaryenSubFloat32(): BinaryenOp
fun BinaryenSubFloat64(): BinaryenOp
fun BinaryenSubInt32(): BinaryenOp
fun BinaryenSubInt64(): BinaryenOp
fun BinaryenSubSatSVecI16x8(): BinaryenOp
fun BinaryenSubSatSVecI8x16(): BinaryenOp
fun BinaryenSubSatUVecI16x8(): BinaryenOp
fun BinaryenSubSatUVecI8x16(): BinaryenOp
fun BinaryenSubVecF32x4(): BinaryenOp
fun BinaryenSubVecF64x2(): BinaryenOp
fun BinaryenSubVecI16x8(): BinaryenOp
fun BinaryenSubVecI32x4(): BinaryenOp
fun BinaryenSubVecI64x2(): BinaryenOp
fun BinaryenSubVecI8x16(): BinaryenOp
fun BinaryenSuspendId(): BinaryenExpressionId
fun BinaryenSwitch(module: BinaryenModuleRef, names: Array<String>, numNames: Int, defaultName: String, condition: BinaryenExpressionRef, value: BinaryenExpressionRef): BinaryenExpressionRef
fun BinaryenSwitchAppendName(expr: BinaryenExpressionRef, name: String): Int
fun BinaryenSwitchGetCondition(expr: BinaryenExpressionRef): BinaryenExpressionRef
fun BinaryenSwitchGetDefaultName(expr: BinaryenExpressionRef): String
fun BinaryenSwitchGetNameAt(expr: BinaryenExpressionRef, index: Int): String
fun BinaryenSwitchGetNumNames(expr: BinaryenExpressionRef): Int
fun BinaryenSwitchGetValue(expr: BinaryenExpressionRef): BinaryenExpressionRef
fun BinaryenSwitchId(): BinaryenExpressionId
fun BinaryenSwitchInsertNameAt(expr: BinaryenExpressionRef, index: Int, name: String)
fun BinaryenSwitchRemoveNameAt(expr: BinaryenExpressionRef, index: Int): String
fun BinaryenSwitchSetCondition(expr: BinaryenExpressionRef, condExpr: BinaryenExpressionRef)
fun BinaryenSwitchSetDefaultName(expr: BinaryenExpressionRef, name: String)
fun BinaryenSwitchSetNameAt(expr: BinaryenExpressionRef, index: Int, name: String)
fun BinaryenSwitchSetValue(expr: BinaryenExpressionRef, valueExpr: BinaryenExpressionRef)
fun BinaryenSwizzleVecI8x16(): BinaryenOp
fun BinaryenTableCopyId(): BinaryenExpressionId
fun BinaryenTableFillId(): BinaryenExpressionId
fun BinaryenTableGet(module: BinaryenModuleRef, name: String, index: BinaryenExpressionRef, type: BinaryenType): BinaryenExpressionRef
fun BinaryenTableGetGetIndex(expr: BinaryenExpressionRef): BinaryenExpressionRef
fun BinaryenTableGetGetTable(expr: BinaryenExpressionRef): String
fun BinaryenTableGetId(): BinaryenExpressionId
fun BinaryenTableGetInitial(table: BinaryenTableRef): Int
fun BinaryenTableGetMax(table: BinaryenTableRef): Int
fun BinaryenTableGetName(table: BinaryenTableRef): String
fun BinaryenTableGetSetIndex(expr: BinaryenExpressionRef, indexExpr: BinaryenExpressionRef)
fun BinaryenTableGetSetTable(expr: BinaryenExpressionRef, table: String)
fun BinaryenTableGetType(table: BinaryenTableRef): BinaryenType
fun BinaryenTableGrow(module: BinaryenModuleRef, name: String, value: BinaryenExpressionRef, delta: BinaryenExpressionRef): BinaryenExpressionRef
fun BinaryenTableGrowGetDelta(expr: BinaryenExpressionRef): BinaryenExpressionRef
fun BinaryenTableGrowGetTable(expr: BinaryenExpressionRef): String
fun BinaryenTableGrowGetValue(expr: BinaryenExpressionRef): BinaryenExpressionRef
fun BinaryenTableGrowId(): BinaryenExpressionId
fun BinaryenTableGrowSetDelta(expr: BinaryenExpressionRef, deltaExpr: BinaryenExpressionRef)
fun BinaryenTableGrowSetTable(expr: BinaryenExpressionRef, table: String)
fun BinaryenTableGrowSetValue(expr: BinaryenExpressionRef, valueExpr: BinaryenExpressionRef)
fun BinaryenTableHasMax(table: BinaryenTableRef): Boolean
fun BinaryenTableImportGetBase(import: BinaryenTableRef): String
fun BinaryenTableImportGetModule(import: BinaryenTableRef): String
fun BinaryenTableSet(module: BinaryenModuleRef, name: String, index: BinaryenExpressionRef, value: BinaryenExpressionRef): BinaryenExpressionRef
fun BinaryenTableSetGetIndex(expr: BinaryenExpressionRef): BinaryenExpressionRef
fun BinaryenTableSetGetTable(expr: BinaryenExpressionRef): String
fun BinaryenTableSetGetValue(expr: BinaryenExpressionRef): BinaryenExpressionRef
fun BinaryenTableSetId(): BinaryenExpressionId
fun BinaryenTableSetInitial(table: BinaryenTableRef, initial: Int)
fun BinaryenTableSetMax(table: BinaryenTableRef, max: Int)
fun BinaryenTableSetName(table: BinaryenTableRef, name: String)
fun BinaryenTableSetSetIndex(expr: BinaryenExpressionRef, indexExpr: BinaryenExpressionRef)
fun BinaryenTableSetSetTable(expr: BinaryenExpressionRef, table: String)
fun BinaryenTableSetSetValue(expr: BinaryenExpressionRef, valueExpr: BinaryenExpressionRef)
fun BinaryenTableSetType(table: BinaryenTableRef, tableType: BinaryenType)
fun BinaryenTableSize(module: BinaryenModuleRef, name: String): BinaryenExpressionRef
fun BinaryenTableSizeGetTable(expr: BinaryenExpressionRef): String
fun BinaryenTableSizeId(): BinaryenExpressionId
fun BinaryenTableSizeSetTable(expr: BinaryenExpressionRef, table: String)
fun BinaryenTagGetName(tag: BinaryenTagRef): String
fun BinaryenTagGetParams(tag: BinaryenTagRef): BinaryenType
fun BinaryenTagGetResults(tag: BinaryenTagRef): BinaryenType
fun BinaryenTagImportGetBase(import: BinaryenTagRef): String
fun BinaryenTagImportGetModule(import: BinaryenTagRef): String
fun BinaryenThrow(module: BinaryenModuleRef, tag: String, operands: Array<BinaryenExpressionRef>?, numOperands: Int): BinaryenExpressionRef
fun BinaryenThrowAppendOperand(expr: BinaryenExpressionRef, operandExpr: BinaryenExpressionRef): Int
fun BinaryenThrowGetNumOperands(expr: BinaryenExpressionRef): Int
fun BinaryenThrowGetOperandAt(expr: BinaryenExpressionRef, index: Int): BinaryenExpressionRef
fun BinaryenThrowGetTag(expr: BinaryenExpressionRef): String
fun BinaryenThrowId(): BinaryenExpressionId
fun BinaryenThrowInsertOperandAt(expr: BinaryenExpressionRef, index: Int, operandExpr: BinaryenExpressionRef)
fun BinaryenThrowRefId(): BinaryenExpressionId
fun BinaryenThrowRemoveOperandAt(expr: BinaryenExpressionRef, index: Int): BinaryenExpressionRef
fun BinaryenThrowSetOperandAt(expr: BinaryenExpressionRef, index: Int, operandExpr: BinaryenExpressionRef)
fun BinaryenThrowSetTag(expr: BinaryenExpressionRef, tagName: String)
fun BinaryenTruncFloat32(): BinaryenOp
fun BinaryenTruncFloat64(): BinaryenOp
fun BinaryenTruncSFloat32ToInt32(): BinaryenOp
fun BinaryenTruncSFloat32ToInt64(): BinaryenOp
fun BinaryenTruncSFloat64ToInt32(): BinaryenOp
fun BinaryenTruncSFloat64ToInt64(): BinaryenOp
fun BinaryenTruncSatSFloat32ToInt32(): BinaryenOp
fun BinaryenTruncSatSFloat32ToInt64(): BinaryenOp
fun BinaryenTruncSatSFloat64ToInt32(): BinaryenOp
fun BinaryenTruncSatSFloat64ToInt64(): BinaryenOp
fun BinaryenTruncSatSVecF32x4ToVecI32x4(): BinaryenOp
fun BinaryenTruncSatUFloat32ToInt32(): BinaryenOp
fun BinaryenTruncSatUFloat32ToInt64(): BinaryenOp
fun BinaryenTruncSatUFloat64ToInt32(): BinaryenOp
fun BinaryenTruncSatUFloat64ToInt64(): BinaryenOp
fun BinaryenTruncSatUVecF32x4ToVecI32x4(): BinaryenOp
fun BinaryenTruncSatZeroSVecF64x2ToVecI32x4(): BinaryenOp
fun BinaryenTruncSatZeroUVecF64x2ToVecI32x4(): BinaryenOp
fun BinaryenTruncUFloat32ToInt32(): BinaryenOp
fun BinaryenTruncUFloat32ToInt64(): BinaryenOp
fun BinaryenTruncUFloat64ToInt32(): BinaryenOp
fun BinaryenTruncUFloat64ToInt64(): BinaryenOp
fun BinaryenTruncVecF32x4(): BinaryenOp
fun BinaryenTruncVecF64x2(): BinaryenOp
fun BinaryenTry(module: BinaryenModuleRef, name: String, body: BinaryenExpressionRef, catchTags: Array<String>, numCatchTags: Int, catchBodies: Array<BinaryenExpressionRef>?, numCatchBodies: Int, delegateTarget: String): BinaryenExpressionRef
fun BinaryenTryAppendCatchBody(expr: BinaryenExpressionRef, catchExpr: BinaryenExpressionRef): Int
fun BinaryenTryAppendCatchTag(expr: BinaryenExpressionRef, catchTag: String): Int
fun BinaryenTryGetBody(expr: BinaryenExpressionRef): BinaryenExpressionRef
fun BinaryenTryGetCatchBodyAt(expr: BinaryenExpressionRef, index: Int): BinaryenExpressionRef
fun BinaryenTryGetCatchTagAt(expr: BinaryenExpressionRef, index: Int): String
fun BinaryenTryGetDelegateTarget(expr: BinaryenExpressionRef): String
fun BinaryenTryGetName(expr: BinaryenExpressionRef): String
fun BinaryenTryGetNumCatchBodies(expr: BinaryenExpressionRef): Int
fun BinaryenTryGetNumCatchTags(expr: BinaryenExpressionRef): Int
fun BinaryenTryHasCatchAll(expr: BinaryenExpressionRef): Boolean
fun BinaryenTryId(): BinaryenExpressionId
fun BinaryenTryInsertCatchBodyAt(expr: BinaryenExpressionRef, index: Int, catchExpr: BinaryenExpressionRef)
fun BinaryenTryInsertCatchTagAt(expr: BinaryenExpressionRef, index: Int, catchTag: String)
fun BinaryenTryIsDelegate(expr: BinaryenExpressionRef): Boolean
fun BinaryenTryRemoveCatchBodyAt(expr: BinaryenExpressionRef, index: Int): BinaryenExpressionRef
fun BinaryenTryRemoveCatchTagAt(expr: BinaryenExpressionRef, index: Int): String
fun BinaryenTrySetBody(expr: BinaryenExpressionRef, bodyExpr: BinaryenExpressionRef)
fun BinaryenTrySetCatchBodyAt(expr: BinaryenExpressionRef, index: Int, catchExpr: BinaryenExpressionRef)
fun BinaryenTrySetCatchTagAt(expr: BinaryenExpressionRef, index: Int, catchTag: String)
fun BinaryenTrySetDelegateTarget(expr: BinaryenExpressionRef, delegateTarget: String)
fun BinaryenTrySetName(expr: BinaryenExpressionRef, name: String)
fun BinaryenTryTableId(): BinaryenExpressionId
fun BinaryenTupleExtract(module: BinaryenModuleRef, tuple: BinaryenExpressionRef, index: Int): BinaryenExpressionRef
fun BinaryenTupleExtractGetIndex(expr: BinaryenExpressionRef): Int
fun BinaryenTupleExtractGetTuple(expr: BinaryenExpressionRef): BinaryenExpressionRef
fun BinaryenTupleExtractId(): BinaryenExpressionId
fun BinaryenTupleExtractSetIndex(expr: BinaryenExpressionRef, index: Int)
fun BinaryenTupleExtractSetTuple(expr: BinaryenExpressionRef, tupleExpr: BinaryenExpressionRef)
fun BinaryenTupleMake(module: BinaryenModuleRef, operands: Array<BinaryenExpressionRef>?, numOperands: Int): BinaryenExpressionRef
fun BinaryenTupleMakeAppendOperand(expr: BinaryenExpressionRef, operandExpr: BinaryenExpressionRef): Int
fun BinaryenTupleMakeGetNumOperands(expr: BinaryenExpressionRef): Int
fun BinaryenTupleMakeGetOperandAt(expr: BinaryenExpressionRef, index: Int): BinaryenExpressionRef
fun BinaryenTupleMakeId(): BinaryenExpressionId
fun BinaryenTupleMakeInsertOperandAt(expr: BinaryenExpressionRef, index: Int, operandExpr: BinaryenExpressionRef)
fun BinaryenTupleMakeRemoveOperandAt(expr: BinaryenExpressionRef, index: Int): BinaryenExpressionRef
fun BinaryenTupleMakeSetOperandAt(expr: BinaryenExpressionRef, index: Int, operandExpr: BinaryenExpressionRef)
fun BinaryenTypeAnyref(): BinaryenType
fun BinaryenTypeArity(t: BinaryenType): Int
fun BinaryenTypeArrayref(): BinaryenType
fun BinaryenTypeAuto(): BinaryenType
fun BinaryenTypeCreate(valueTypes: LongArray?, numTypes: Int): BinaryenType
fun BinaryenTypeEqref(): BinaryenType
fun BinaryenTypeExpand(t: BinaryenType, buf: LongArray?)
fun BinaryenTypeExternref(): BinaryenType
fun BinaryenTypeFloat32(): BinaryenType
fun BinaryenTypeFloat64(): BinaryenType
fun BinaryenTypeFromHeapType(heapType: BinaryenHeapType, nullable: Boolean): BinaryenType
fun BinaryenTypeFuncref(): BinaryenType
fun BinaryenTypeGetHeapType(type: BinaryenType): BinaryenHeapType
fun BinaryenTypeI31ref(): BinaryenType
fun BinaryenTypeInt32(): BinaryenType
fun BinaryenTypeInt64(): BinaryenType
fun BinaryenTypeIsNullable(type: BinaryenType): Boolean
fun BinaryenTypeNone(): BinaryenType
fun BinaryenTypeNullExternref(): BinaryenType
fun BinaryenTypeNullFuncref(): BinaryenType
fun BinaryenTypeNullref(): BinaryenType
fun BinaryenTypeStringref(): BinaryenType
fun BinaryenTypeStructref(): BinaryenType
fun BinaryenTypeUnreachable(): BinaryenType
fun BinaryenTypeVec128(): BinaryenType
fun BinaryenUnary(module: BinaryenModuleRef, op: BinaryenOp, value: BinaryenExpressionRef): BinaryenExpressionRef
fun BinaryenUnaryGetOp(expr: BinaryenExpressionRef): BinaryenOp
fun BinaryenUnaryGetValue(expr: BinaryenExpressionRef): BinaryenExpressionRef
fun BinaryenUnaryId(): BinaryenExpressionId
fun BinaryenUnarySetOp(expr: BinaryenExpressionRef, op: BinaryenOp)
fun BinaryenUnarySetValue(expr: BinaryenExpressionRef, valueExpr: BinaryenExpressionRef)
fun BinaryenUnreachable(module: BinaryenModuleRef): BinaryenExpressionRef
fun BinaryenUnreachableId(): BinaryenExpressionId
fun BinaryenWrapInt64(): BinaryenOp
fun BinaryenXorInt32(): BinaryenOp
fun BinaryenXorInt64(): BinaryenOp
fun BinaryenXorVec128(): BinaryenOp
fun ExpressionRunnerCreate(module: BinaryenModuleRef, flags: ExpressionRunnerFlags, maxDepth: Int, maxLoopIterations: Int): ExpressionRunnerRef
fun ExpressionRunnerFlagsDefault(): ExpressionRunnerFlags
fun ExpressionRunnerFlagsPreserveSideeffects(): ExpressionRunnerFlags
fun ExpressionRunnerRunAndDispose(runner: ExpressionRunnerRef, expr: BinaryenExpressionRef): BinaryenExpressionRef
fun ExpressionRunnerSetGlobalValue(runner: ExpressionRunnerRef, name: String, value: BinaryenExpressionRef): Boolean
fun ExpressionRunnerSetLocalValue(runner: ExpressionRunnerRef, index: Int, value: BinaryenExpressionRef): Boolean
fun RelooperAddBlock(relooper: RelooperRef, code: BinaryenExpressionRef): RelooperBlockRef
fun RelooperAddBlockWithSwitch(relooper: RelooperRef, code: BinaryenExpressionRef, condition: BinaryenExpressionRef): RelooperBlockRef
fun RelooperAddBranch(from: RelooperBlockRef, to: RelooperBlockRef, condition: BinaryenExpressionRef, code: BinaryenExpressionRef)
fun RelooperAddBranchForSwitch(from: RelooperBlockRef, to: RelooperBlockRef, indexes: LongArray?, numIndexes: Int, code: BinaryenExpressionRef)
fun RelooperCreate(module: BinaryenModuleRef): RelooperRef
fun RelooperRenderAndDispose(relooper: RelooperRef, entry: RelooperBlockRef, labelHelper: Int): BinaryenExpressionRef
fun TypeBuilderBuildAndDispose(builder: TypeBuilderRef, heapTypes: Array<BinaryenHeapType>?, errorIndex: LongArray?, errorReason: Array<TypeBuilderErrorReason>?): Boolean
fun TypeBuilderCreate(size: Int): TypeBuilderRef
fun TypeBuilderCreateRecGroup(builder: TypeBuilderRef, index: Int, length: Int)
fun TypeBuilderErrorReasonForwardChildReference(): TypeBuilderErrorReason
fun TypeBuilderErrorReasonForwardSupertypeReference(): TypeBuilderErrorReason
fun TypeBuilderErrorReasonInvalidSupertype(): TypeBuilderErrorReason
fun TypeBuilderErrorReasonSelfSupertype(): TypeBuilderErrorReason
fun TypeBuilderGetSize(builder: TypeBuilderRef): Int
fun TypeBuilderGetTempHeapType(builder: TypeBuilderRef, index: Int): BinaryenHeapType
fun TypeBuilderGetTempRefType(builder: TypeBuilderRef, heapType: BinaryenHeapType, nullable: Int): BinaryenType
fun TypeBuilderGetTempTupleType(builder: TypeBuilderRef, types: LongArray?, numTypes: Int): BinaryenType
fun TypeBuilderGrow(builder: TypeBuilderRef, count: Int)
fun TypeBuilderSetArrayType(builder: TypeBuilderRef, index: Int, elementType: BinaryenType, elementPackedType: BinaryenPackedType, elementMutable: Int)
fun TypeBuilderSetOpen(builder: TypeBuilderRef, index: Int)
fun TypeBuilderSetSignatureType(builder: TypeBuilderRef, index: Int, paramTypes: BinaryenType, resultTypes: BinaryenType)
fun TypeBuilderSetStructType(builder: TypeBuilderRef, index: Int, fieldTypes: LongArray?, fieldPackedTypes: Array<BinaryenPackedType>?, fieldMutables: Array<Boolean>?, numFields: Int)
fun TypeBuilderSetSubType(builder: TypeBuilderRef, index: Int, superType: BinaryenHeapType)
}
