#!/usr/bin/env bash

kops export kubecfg --state @kubecfgState@ --name @kubecfgName@

kubectl set image deployment/ap-tms-deployment ap-tms=@dockerTagBase@/ap-ims:@version@