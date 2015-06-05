/// <reference path="../../types/tsd.d.ts"/>
/// <reference path="../../app.module.ts"/>
/// <reference path="../../shared/service/ideaService.ts"/>
/// <reference path="../../shared/model/idea.ts"/>

module home {
    'use strict';

    interface IdeaRouteParams extends ng.route.IRouteParamsService {
        id: number;
    }

    /** The controller for the home view. */
    export class IdeaController {

        /** The idea service. */
        private ideaService: service.IdeaService;

        /**
         * Constructs a home controller.
         *
         * @param ideaService the idea service
         */
        constructor($routeParams: IdeaRouteParams, ideaService: service.IdeaService) {
            this.ideaService = ideaService;
            this.idea = ideaService.get($routeParams.id);
        }

        idea: model.Idea;
    }

    angular
        .module('app')
        .controller('IdeaController', IdeaController);
};