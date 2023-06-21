# Gatling plugin for SBT

A simple showcase of an SBT project using the Gatling plugin for SBT. Refer to the plugin documentation
[on the Gatling website](https://gatling.io/docs/current/extensions/sbt_plugin/) for usage.

This project is written in Scala. For other languages, consider using
[our other supported build plugins](https://gatling.io/docs/gatling/reference/current/extensions/).

It includes:

- minimal `build.sbt`, requiring [SBT 1](https://www.scala-sbt.org/download.html)
- latest version of the `io.gatling:gatling-sbt` plugin applied
- sample [Simulation](https://gatling.io/docs/gatling/reference/current/general/concepts/#simulation) class,
  demonstrating sufficient Gatling functionality
- proper source file layout
  - both the `test` and `it` (integration test) configurations are shown

Install Plugin sbt - Linux

echo "deb https://repo.scala-sbt.org/scalasbt/debian all main" | sudo tee /etc/apt/sources.list.d/sbt.list
echo "deb https://repo.scala-sbt.org/scalasbt/debian /" | sudo tee /etc/apt/sources.list.d/sbt_old.list
curl -sL "https://keyserver.ubuntu.com/pks/lookup?op=get&search=0x2EE0EA64E40A89B84B2DF73499E82A75642AC823" | sudo apt-key add
sudo apt-get update
sudo apt-get install sbt

Execute Test

sbt gatling:test

Report

> request count 1500 (OK=1500 KO=0 )
> min response time 367 (OK=367 KO=- )
> max response time 10130 (OK=10130 KO=- )
> mean response time 2172 (OK=2172 KO=- )
> std deviation 1107 (OK=1107 KO=- )
> response time 90th percentile 3852 (OK=3852 KO=- )
> response time 75th percentile 2909 (OK=2909 KO=- )
> response time 95th percentile 4208 (OK=4208 KO=- )
> response time 99th percentile 4770 (OK=4770 KO=- )
> mean requests/sec 125 (OK=125 KO=- )
> ---- Response Time Distribution ------------------------------------------------
> t < 800 ms 65 ( 4%)
> 800 ms <= t < 1200 ms 294 ( 20%)
> t >= 1200 ms 1141 ( 76%)
> failed 0 ( 0%)
