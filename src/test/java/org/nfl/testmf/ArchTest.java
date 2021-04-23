package org.nfl.testmf;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.core.importer.ImportOption;
import org.junit.jupiter.api.Test;

class ArchTest {

    @Test
    void servicesAndRepositoriesShouldNotDependOnWebLayer() {
        JavaClasses importedClasses = new ClassFileImporter()
            .withImportOption(ImportOption.Predefined.DO_NOT_INCLUDE_TESTS)
            .importPackages("org.nfl.testmf");

        noClasses()
            .that()
            .resideInAnyPackage("org.nfl.testmf.service..")
            .or()
            .resideInAnyPackage("org.nfl.testmf.repository..")
            .should()
            .dependOnClassesThat()
            .resideInAnyPackage("..org.nfl.testmf.web..")
            .because("Services and repositories should not depend on web layer")
            .check(importedClasses);
    }
}
