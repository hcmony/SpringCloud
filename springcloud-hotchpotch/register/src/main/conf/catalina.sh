#!/bin/sh

#
#  All content copyright (c) 2003-2008 Terracotta, Inc.,
#  except as may otherwise be noted in a separate copyright notice.
#  All rights reserved.
#

FINDNAME=$0
while [ -h $FINDNAME ] ; do FINDNAME=`ls -ld $FINDNAME | awk '{print $NF}'` ; done
SERVER_HOME=`echo $FINDNAME | sed -e 's@/[^/]*$@@'`
SERVER_JAR=`ls ../lib/${jar.name}`
SERVER_NAME=`hostname -s`
unset FINDNAME

ARGS=($*)
for ((i=0; i<${#ARGS[@]}; i++)); do
  case "${ARGS[$i]}" in
  -D*) export JAVA_OPTS="${JAVA_OPTS} ${ARGS[$i]}" ;;
  -Heap*) HEAP_MEMORY="${ARGS[$i+1]}" ;;
  -Perm*) PERM_MEMORY="${ARGS[$i+1]}" ;;
  -JmxPort*)  JMX_PORT="${ARGS[$i+1]}" ;;
    *) parameters="${parameters} ${ARGS[$i]}" ;;
  esac
done

exec "${JAVA_HOME}/bin/java" ${JAVA_OPTS} -server -Xms${HEAP_MEMORY} -Xmx${HEAP_MEMORY} -XX:+HeapDumpOnOutOfMemoryError -jar ${SERVER_JAR}