#!/bin/bash
kill `ps axu|grep ${project.name}|grep -v grep |awk '{print $2}'`