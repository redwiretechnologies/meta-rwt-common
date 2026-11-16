# Host GCC 15 (Ubuntu >= 25.10) no longer pulls in <cstdint> transitively, and
# qtdeclarative 5.15 (e.g. src/qml/compiler/qv4compiler.cpp) uses uintptr_t /
# uint32_t without including it. Force-include it for the native build only;
# the target toolchain (GCC 13) is unaffected.
CXXFLAGS:append:class-native = " -include cstdint"
