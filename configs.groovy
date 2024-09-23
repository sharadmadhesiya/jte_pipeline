libraries:
  - maven
  - sonarqube
  - ansible

allow_scm_jenkinsfile: true

application_environments:
  dev:
    ip_addresses:
      - 192.168.1.1
      - 192.168.1.2
    long_name: Pre Development Environment
  prod:
    ip_addresses:
      - 101.112.0.34
    long_name: Production Environment
