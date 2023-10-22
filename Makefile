# VARIABLES
PROJECTPATH := '/home/mizo/Desktop/Jakarta EE projects/Simulation_jee/'
APPNAME := EasyBankEE
APPWARPATH := /home/mizo/Desktop/Jakarta EE projects/Simulation_jee/target/$(APPNAME).war
PAYARAPATH := /home/mizo/Downloads/payara-6.2023.9/payara6/bin
DOMAIN := domain1

# COMMANDS
BUILD := cd $(PROJECTPATH) && mvn clean package 
GO-TO-PAYARA := cd $(PAYARAPATH)
RUN-SERVER := $(GO-TO-PAYARA) && ./asadmin start-domain
STOP-SERVER := $(GO-TO-PAYARA) && ./asadmin stop-domain
UNDEPLOY := $(GO-TO-PAYARA) && ./asadmin undeploy $(APPNAME)
DEPLOY := $(GO-TO-PAYARA) && ./asadmin deploy '$(APPWARPATH)'


# TARGETS
.PHONY: all clean build deploy undeploy run-server stop-server

all: build deploy

clean: 
	mvn clean

build: clean
	mvn package

deploy: undeploy
	$(DEPLOY)

undeploy: 
	@if $(PAYARAPATH)/asadmin list-applications | grep -q $(APPNAME); then \
		$(UNDEPLOY); \
	fi

run-server: 
		$(RUN-SERVER); 

stop-server:
		$(STOP-SERVER); 